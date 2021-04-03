package org.erp.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.erp.school.dto.DocumentDto;
import org.erp.school.dto.DocumentRequestDto;
import org.erp.school.service.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api
@RequestMapping("/document")
@Slf4j
public class DocumentController {

  private final DocumentService documentService;

  public DocumentController(DocumentService documentService) {
    this.documentService = documentService;
  }

  @PostMapping(name = "Endpoint for uploading documents")
  public @ResponseBody ResponseEntity postDocuments(
      @RequestParam(name = "docRequestJson") String docRequestJson,
      @RequestParam(name = "documents") MultipartFile[] documents) {

    try {
      ObjectMapper objMapper = new ObjectMapper();
      log.info(String.format("Request: %s", docRequestJson));
      DocumentRequestDto docReq = objMapper.readValue(docRequestJson, DocumentRequestDto.class);
      documentService.createDocuments(documents, docReq.getClientId());
    } catch (Exception e) {
      log.error("Could not create document", e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping(path = "/{documentId}", name = "Endpoint for fetching documents")
  public @ResponseBody ResponseEntity getDocument(@Valid @PathVariable("documentId") String docId) {

    String fileBase64 = null;
    try {
      fileBase64 = documentService.getDocument(docId);
    } catch (Exception e) {
      log.error("Exception while getting document", e);
    }

    return new ResponseEntity<>(fileBase64, HttpStatus.OK);
  }

  @DeleteMapping(path = "/{documentId}", name = "Endpoint for deleting documents")
  public ResponseEntity<String> removeDocument(
      @Valid @PathVariable("documentId") String documentId) {
    try {
      documentService.deleteDocument(documentId);
      return ResponseEntity.ok("File deleted");
    } catch (FileNotFoundException e) {
      log.error("File could not be found", e);
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping(
      path = "/client/{clientId}",
      name = "Endpoint for fetching all documents for an client")
  public @ResponseBody ResponseEntity<List<DocumentDto>> fetchDocuments(
      @Valid @PathVariable("clientId") String clientId) {
    try {
      var documentDtoList =
          documentService.fetchDocumentsClientId(clientId).stream()
              .map(document -> new DocumentDto(document.getUri()))
              .collect(Collectors.toList());
      return new ResponseEntity<>(documentDtoList, HttpStatus.OK);
    } catch (Exception ex) {
      log.error("Could not fetch documents for client {}", clientId, ex);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
