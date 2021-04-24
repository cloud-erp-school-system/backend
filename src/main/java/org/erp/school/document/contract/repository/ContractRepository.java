package org.erp.school.document.contract.repository;

import org.erp.school.document.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, String> {}
