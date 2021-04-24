package org.erp.school.address.repository;

import org.erp.school.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {}
