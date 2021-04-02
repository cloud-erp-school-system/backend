package org.erp.school.service;

import org.erp.school.dto.DocumentRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface DocumentService {

    public List<String> fetchAllDocIdsForOrg(String orgId);

    public boolean deleteDocuments(String docIds);

    public void postDocuments(MultipartFile[] documents, DocumentRequestDto docRequest);

    public String getFile(String docId) throws IOException;
}
