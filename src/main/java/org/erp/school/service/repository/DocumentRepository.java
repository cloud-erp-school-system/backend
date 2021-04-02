package org.erp.school.service.repository;

import org.erp.school.model.Customer;
import org.erp.school.model.Files;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends CrudRepository<Files, String> {

    @Query("select f.uuid from Files f where f.organizationId = ?1")
    public List<String> getDocIdsFromOrgId(String orgId);

}
