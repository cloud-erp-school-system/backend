package org.erp.school.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.erp.school.model.Client;
import org.erp.school.model.Document;
import org.erp.school.service.DocumentService;
import org.erp.school.service.repository.ClientRepository;
import org.erp.school.service.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class DocumentServiceImpl implements DocumentService {
  private final DocumentRepository documentRepository;
  private final ClientRepository clientRepository;

  @Value("${docs.storage.type}")
  private String storageType;

  @Value("${docs.storage.directory}")
  private String storageDirectory;

  public DocumentServiceImpl(
      DocumentRepository documentRepository, ClientRepository clientRepository) {
    this.documentRepository = documentRepository;
    this.clientRepository = clientRepository;
  }

  @Override
  public List<Document> fetchDocumentsClientId(String clientId) {
    return clientRepository.getOne(clientId).getDocuments();
  }

  @Transactional
  @Override
  public void deleteDocument(String documentId) throws FileNotFoundException {
    var document = documentRepository.findById(documentId).orElseThrow(FileNotFoundException::new);
    var file = new File(document.getUri());
    if (!file.exists()) {
      throw new FileNotFoundException(String.format("File %s not found.", file));
    }

    // delete from database
    // ToDo: Delete from relation of Client
    documentRepository.deleteById(document.getId());

    // delete file
    if (!file.delete()) {
      log.warn("Could not delete file " + file);
    }
  }

  @Transactional
  @Override
  public List<Document> createDocuments(MultipartFile[] documents, String clientId) {
    // upload docs to storage unit
    var relativePath = getRelativePathForFiles();
    var folderStorage = new File(relativePath);

    log.info(String.format("Location to store files today: %s", relativePath));

    if (!folderStorage.exists()) {
      if (!folderStorage.mkdirs()) {
        throw new RuntimeException(
            String.format("Could not create folder to save files %s", folderStorage));
      }
    }

    List<Document> documentList = new ArrayList<>();
    for (MultipartFile file : documents) {
      var path = Paths.get(relativePath, UUID.randomUUID().toString());

      // create on database
      var document = new Document();
      document.setUri(path.toFile().getPath());
      document.setFileSize(file.getSize());
      document.setFileType(file.getContentType());
      document.setStorageType(storageType);
      document.setCreatedDate(LocalDateTime.now());
      // create on storageType
      try (OutputStream os = Files.newOutputStream(path)) {
        os.write(file.getBytes());
        documentList.add(document);
      } catch (IOException e) {
        log.error("Could not create file {}", path, e);
      }
    }

    // once uploaded persist in db
    documentRepository.saveAll(documentList);

    if (StringUtils.isNotEmpty(clientId)) {
      Client client = clientRepository.findById(clientId).orElseThrow();
      client.getDocuments().addAll(documentList);
      clientRepository.save(client);
    }
    return documentList;
  }

  @Override
  public File getDocument(String documentId) throws IOException {
    var document = documentRepository.findById(documentId).orElseThrow();
    var file = new File(document.getUri());

    if (file.exists()) {
      return file;
    } else {
      throw new FileNotFoundException("File not found" + file.getAbsolutePath());
    }
  }

  private String getRelativePathForFiles() {
    var instance = Calendar.getInstance();
    return storageDirectory
        + File.separator
        + instance.get(Calendar.YEAR)
        + File.separator
        + (instance.get(Calendar.MONTH) + 1)
        + File.separator
        + instance.get(Calendar.DAY_OF_MONTH);
  }
}
