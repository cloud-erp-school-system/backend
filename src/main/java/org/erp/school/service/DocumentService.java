package org.erp.school.service;

import org.erp.school.model.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public interface DocumentService {

  List<Document> fetchDocumentsClientId(String clientId);

  void deleteDocument(String docIds) throws IOException;

  List<Document> createDocuments(MultipartFile[] documents, String clientId);

  File getDocument(String documentId) throws IOException;
}
