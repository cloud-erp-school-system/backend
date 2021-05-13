package org.erp.school.client.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.erp.school.client.dto.ClientDTO;
import org.erp.school.client.services.ClientService;
import org.erp.school.document.dto.DocumentDto;
import org.erp.school.document.service.DocumentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController("/client")
@Api
@Slf4j
public class ClientController {

  private final DocumentService documentService;
  private final ClientService clientService;

  public ClientController(DocumentService documentService, ClientService clientService) {
    this.documentService = documentService;
    this.clientService = clientService;
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

  @GetMapping
  public ResponseEntity<Page<ClientDTO>> getAllClients(Pageable pageable) {
    return ResponseEntity.ok(clientService.getAllClients(pageable));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ClientDTO> getClient(@PathVariable String id) {
    return ResponseEntity.ok(clientService.getClient(id));
  }

  @PostMapping
  public ResponseEntity<Void> saveClient(@RequestBody @Valid ClientDTO dto) {
    return ResponseEntity.created(clientService.saveClient(dto)).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateClient(@RequestBody @Valid ClientDTO dto, @PathVariable String id) {
    dto.setId(id);
    clientService.updateClient(dto);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteClient(@PathVariable String id) {
    clientService.deleteClient(id);
    return ResponseEntity.noContent().build();
  }
}
