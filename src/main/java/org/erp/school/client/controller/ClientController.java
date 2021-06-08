package org.erp.school.client.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.erp.school.client.dto.ClientDto;
import org.erp.school.client.services.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/client")
@Api
@Slf4j
public class ClientController {

  private final ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @GetMapping
  public ResponseEntity<Page<ClientDto>> getAllClients(Pageable pageable) {
    return ResponseEntity.ok(clientService.getAllClients(pageable));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ClientDto> getClient(@PathVariable String id) {
    return ResponseEntity.ok(clientService.getClient(id));
  }

  @PostMapping
  public ResponseEntity<Void> saveClient(@RequestBody @Valid ClientDto dto) {
    return ResponseEntity.created(clientService.saveClient(dto)).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateClient(
          @RequestBody @Valid ClientDto dto, @PathVariable String id) {
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
