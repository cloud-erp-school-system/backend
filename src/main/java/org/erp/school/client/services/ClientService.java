package org.erp.school.client.services;

import org.erp.school.client.dto.ClientDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URI;

public interface ClientService {
    Page<ClientDTO> getAllClients(Pageable pageable);
    ClientDTO getClient(String id);
    URI saveClient(ClientDTO dto);
    void updateClient(ClientDTO dto);
    void deleteClient(String id);
}
