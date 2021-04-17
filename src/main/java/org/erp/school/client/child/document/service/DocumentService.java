package org.erp.school.client.child.document.service;

import org.erp.school.client.child.document.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface DocumentService {

  List<Document> fetchDocumentsClientId(String clientId);

  void deleteDocument(String docIds) throws IOException;

  List<Document> createDocuments(MultipartFile[] documents, String clientId);

  File getDocument(String documentId) throws IOException;
}
