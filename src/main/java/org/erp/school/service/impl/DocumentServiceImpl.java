package org.erp.school.service.impl;

import org.apache.commons.io.FileUtils;
import org.erp.school.controller.DocumentController;
import org.erp.school.dto.DocumentRequestDto;
import org.erp.school.service.DocumentService;
import org.erp.school.service.repository.DocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class DocumentServiceImpl implements DocumentService {

    private static Logger LOGGER = LoggerFactory.getLogger(DocumentServiceImpl.class);

    @Autowired
    private DocumentRepository filesRepository;

    @Value("${docs.storage.directory}")
    private String storageDirectory;

    @PostConstruct
    public void doSomething() {
        LOGGER.info("Storage : {}", storageDirectory);
    }

    @Override
    public List<String> fetchAllDocIdsForOrg(String orgId) {

        List<String> documentIds = filesRepository.getDocIdsFromOrgId(orgId);

        return documentIds;
    }

    @Transactional
    @Override
    public boolean deleteDocuments(String docId) {
        boolean docDeleted = true;

        try {
            Optional<org.erp.school.model.Files> document = filesRepository.findById(docId);

            if (!document.isPresent()) {
                LOGGER.info("No files to delete");
                return true;
            }
            // delete form storage unit
            try {
                File f = new File(document.get().getRelativePath() + "/" + document.get().getFileName());

                f.delete();

                // delete from db
                filesRepository.deleteById(document.get().getUuid());

            } catch (Exception ex) {
                LOGGER.info("Exception while deleting docs id {} {}", document.get().getUuid(), ex.getMessage());
            }

        } catch (Exception e) {
            // loggers to be added
            docDeleted = false;
            LOGGER.info("Exception while deleting docs {}", e.getMessage());
        }

        return docDeleted;
    }

    @Transactional
    @Override
    public void postDocuments(MultipartFile[] documents, DocumentRequestDto docRequest) {

        // upload docs to storage unit
        String relativePath = storageDirectory + "/" + docRequest.getOrgId();
        File newFile = new File(relativePath);
        LOGGER.info("location : ", relativePath);

        if (!newFile.exists()) {
            newFile.mkdirs();
        }

        List<org.erp.school.model.Files> documentList = new ArrayList<org.erp.school.model.Files>();
        for (MultipartFile file : documents) {
            // upload file
            Path filePath = Paths.get(relativePath, UUID.randomUUID().toString());
            org.erp.school.model.Files entity = new org.erp.school.model.Files();
            entity.setCreatedBy(docRequest.getOrgId());
            entity.setFileName(filePath.getFileName().toString());
            entity.setFileSize(file.getSize());
            entity.setFileType(file.getContentType());
            entity.setModifiedBy(docRequest.getOrgId());
            entity.setRelativePath(relativePath);
            entity.setStorageSpace("H2");
            entity.setOrganizationId(docRequest.getOrgId());

            try (OutputStream os = Files.newOutputStream(filePath)) {
                os.write(file.getBytes());
            } catch (IOException e) {
                // logger and exception handling
                entity = null;
                LOGGER.info("Exception while creating file : {}", e.getMessage());
            }
            if (null != entity) {
                documentList.add(entity);
            }
        }

        // once uploaded persist in db
        filesRepository.saveAll(documentList);
    }

    @Override
    public String getFile(String docId) throws IOException {

        Optional<org.erp.school.model.Files> document = filesRepository.findById(docId);
        String base64Doc = null;

        if (document.isPresent()) {
            LOGGER.info("inside : ");
            String documentPath = document.get().getRelativePath() + "/" + document.get().getFileName();

            File file = new File(documentPath);

            if (file.exists()) {
                byte[] fileContent = FileUtils.readFileToByteArray(file);
                base64Doc = Base64.getEncoder().encodeToString(fileContent);
            }
        }

        return base64Doc;
    }

}
