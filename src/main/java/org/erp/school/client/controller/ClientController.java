package org.erp.school.client.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.erp.school.client.child.document.dto.DocumentDto;
import org.erp.school.client.child.document.service.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api
@RequestMapping("/client")
@Slf4j
public class ClientController {

  private final DocumentService documentService;

  public ClientController(DocumentService documentService) {
    this.documentService = documentService;
  }

  @GetMapping(
      path = "/{clientId}/documents",
      name = "Endpoint for fetching all documents for an client")
  public @ResponseBody ResponseEntity<List<DocumentDto>> fetchDocuments(
      @Valid @PathVariable("clientId") String clientId) {
    try {
      var documentDtoList =
          documentService.fetchDocumentsClientId(clientId).stream()
              .map(document -> new DocumentDto(document.getId(), document.getUri()))
              .collect(Collectors.toList());
      return new ResponseEntity<>(documentDtoList, HttpStatus.OK);
    } catch (Exception ex) {
      log.error("Could not fetch documents for client {}", clientId, ex);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
