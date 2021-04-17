package org.erp.school.client.repository;

import org.erp.school.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Client findByDocumentsId(String id);
}
