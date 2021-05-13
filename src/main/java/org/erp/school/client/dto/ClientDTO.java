package org.erp.school.client.dto;

import lombok.*;
import org.erp.school.client.Client;
import org.erp.school.global.enums.SizeCategory;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ClientDTO {
  private String id;

  @NotBlank private String name;

  @URL private String website;

  private SizeCategory staffSize;

  private SizeCategory studentSize;

  @NotBlank private String verificationStatus;

  private Timestamp createdDate;

  public static ClientDTO fromEntity(Client client) {
    return ClientDTO.builder()
        .createdDate(client.getCreatedDate())
        .id(client.getId())
        .name(client.getName())
        .staffSize(client.getStaffSize())
        .studentSize(client.getStudentSize())
        .verificationStatus(client.getVerificationStatus())
        .website(client.getWebsite())
        .build();
  }
}
