package org.erp.school.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.erp.school.controller.util.SwaggerConstants;
import org.erp.school.dto.DocumentDto;
import org.erp.school.service.DocumentService;
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
import java.io.FileNotFoundException;
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
