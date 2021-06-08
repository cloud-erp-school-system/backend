package org.erp.school.client.services;

import org.erp.school.client.dto.ClientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URI;

public interface ClientService {
    Page<ClientDto> getAllClients(Pageable pageable);
    ClientDto getClient(String id);
    URI saveClient(ClientDto dto);
    void updateClient(ClientDto dto);
    void deleteClient(String id);
}
