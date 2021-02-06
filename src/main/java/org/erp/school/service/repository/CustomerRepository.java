package org.erp.school.service.repository;

import org.erp.school.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);
}
