package org.erp.school.document.contract.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.erp.school.document.contract.enums.ContractStatus;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NotBlank
@Builder
public class ContractDto {
  private String id;
  @NotBlank private String designation;

  private Timestamp received;

  private Timestamp signedOn;

  private String signedBy;

  private ContractStatus contractStatus;
}
