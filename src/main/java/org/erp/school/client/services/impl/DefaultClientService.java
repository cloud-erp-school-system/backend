package org.erp.school.client.services.impl;

import org.erp.school.client.Client;
import org.erp.school.client.dto.ClientDTO;
import org.erp.school.client.exception.ClientNotFoundException;
import org.erp.school.client.repository.ClientRepository;
import org.erp.school.client.services.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class DefaultClientService implements ClientService {
  private final ClientRepository clientRepository;

  public DefaultClientService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public Page<ClientDTO> getAllClients(Pageable pageable) {
    return clientRepository.findAll(pageable).map(ClientDTO::fromEntity);
  }

  @Override
  public ClientDTO getClient(String id) {
    Client client =
        clientRepository
            .findById(id)
            .orElseThrow(() -> new ClientNotFoundException("Cannot find client with id:" + id));
    return ClientDTO.fromEntity(client);
  }

  @Override
  public URI saveClient(ClientDTO dto) {
    return ServletUriComponentsBuilder.fromCurrentRequest()
        .path("client")
        .buildAndExpand(clientRepository.save(Client.fromDto(dto)))
        .toUri();
  }

  @Override
  public void updateClient(ClientDTO dto) {
    clientRepository
        .findById(dto.getId())
        .orElseThrow(
            () -> new ClientNotFoundException("Cannot find client with id:" + dto.getId()));
    clientRepository.save(Client.fromDto(dto));
  }

  @Override
  public void deleteClient(String id) {
    clientRepository.deleteById(id);
  }
}
