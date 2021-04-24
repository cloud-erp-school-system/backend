package org.erp.school.document.contract;

import lombok.Data;
import org.erp.school.document.contract.enums.ContractStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
public class Contract {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String designation;

    private Timestamp received;

    private Timestamp signedOn;

    private String signedBy;

    private ContractStatus contractStatus;
}
