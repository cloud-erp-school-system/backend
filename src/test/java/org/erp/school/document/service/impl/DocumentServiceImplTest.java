package org.erp.school.document.service.impl;

import lombok.SneakyThrows;
import org.erp.school.client.repository.ClientRepository;
import org.erp.school.document.Document;
import org.erp.school.document.repository.DocumentRepository;
import org.erp.school.prototype.ClientPrototype;
import org.erp.school.prototype.DocumentPrototype;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DocumentServiceImplTest {

    private DocumentRepository documentRepository;
    private ClientRepository clientRepository;
    private DocumentServiceImpl documentService;

    @BeforeEach
    void init(){
        documentRepository = mock(DocumentRepository.class);
        clientRepository = mock(ClientRepository.class);
        documentService = new DocumentServiceImpl(documentRepository,clientRepository);
    }

    @Test
    void fetchDocumentsClientId() {
        when(clientRepository.findById(eq("Test_Client"))).thenReturn(ClientPrototype.getTestClient());
        List<Document> testDocs =  documentService.fetchDocumentsClientId("Test_Client");
        System.out.println(testDocs);
        assertThat(testDocs).isNotNull();
    }

    @Test
    void deleteDocument() {
    }

    @Test
    void createDocuments() {
    }

    @SneakyThrows
    @Test
    void getDocument() {
        ClassLoader classLoader = getClass().getClassLoader();
        when(documentRepository.findById(eq("Test_Document1"))).thenReturn(Optional.of(DocumentPrototype.getTestDocument()));
        File doc = documentService.getDocument("Test_Document1");
        assertThat(doc).isNotNull();
        assertThat(doc.exists()).isTrue();
    }
}