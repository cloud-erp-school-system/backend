package org.erp.school.client.child.document.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.erp.school.global.util.SwaggerConstants;
import org.erp.school.client.child.document.dto.DocumentDto;
import org.erp.school.client.child.document.service.DocumentService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
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
import java.io.File;
import java.io.IOException;
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
  public @ResponseBody ResponseEntity<List<DocumentDto>> postDocuments(
      @RequestParam(name = "clientId", required = false) String clientId,
      @RequestParam(name = "documents") MultipartFile[] documents) {

    try {
      log.info(String.format("Upload file for clientId: %s", clientId));
      var documentDtoList =
          documentService.createDocuments(documents, clientId).stream()
              .map(document -> new DocumentDto(document.getId(), document.getUri()))
              .collect(Collectors.toList());
      return new ResponseEntity<>(documentDtoList, HttpStatus.CREATED);
    } catch (Exception e) {
      log.error("Could not create document", e);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping(path = "/{documentId}", name = "Endpoint for fetching documents")
  @ApiOperation(value = "Download a document", notes = "Download a document by its documentIt")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = SwaggerConstants.OK_MESSAGE, response = Resource.class)
      })
  public @ResponseBody ResponseEntity<Resource> getDocument(
      @Valid @PathVariable("documentId") String docId) {
    try {
      File file = documentService.getDocument(docId);
      FileSystemResource resource = new FileSystemResource(file);
      MediaType mediaType =
          MediaTypeFactory.getMediaType(resource).orElse(MediaType.APPLICATION_OCTET_STREAM);
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(mediaType);
      headers.setContentLength(file.length());

      ContentDisposition disposition =
          ContentDisposition.builder("attachment").filename(file.getName()).build();
      headers.setContentDisposition(disposition);
      return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping(path = "/{documentId}", name = "Endpoint for deleting documents")
  public ResponseEntity<String> removeDocument(
      @Valid @PathVariable("documentId") String documentId) {
    try {
      documentService.deleteDocument(documentId);
      return ResponseEntity.ok("File deleted");
    } catch (IOException e) {
      log.error("File could not be removed", e);
      return ResponseEntity.notFound().build();
    }
  }
}
