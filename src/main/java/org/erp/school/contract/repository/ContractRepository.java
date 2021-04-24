package org.erp.school.contract.repository;

import org.erp.school.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, String> {}
