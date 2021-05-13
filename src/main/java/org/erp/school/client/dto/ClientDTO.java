package org.erp.school.client.dto;

import lombok.*;
import org.erp.school.activity.Activity;
import org.erp.school.activity.dto.ActivityDto;
import org.erp.school.address.Address;
import org.erp.school.address.dto.AddressDto;
import org.erp.school.document.Document;
import org.erp.school.document.contract.Contract;
import org.erp.school.document.contract.dto.ContractDto;
import org.erp.school.document.dto.DocumentDto;
import org.erp.school.global.enums.SizeCategory;
import org.erp.school.request.ClientRequest;
import org.erp.school.request.dto.RequestSummaryDto;
import org.erp.school.user.User;
import org.erp.school.user.dto.UserDto;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Page;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ClientDTO {
  private String id;

  private String name;

  private String website;

  private SizeCategory staffSize;

  private SizeCategory studentSize;

  private Page<AddressDto> address;

  private Page<UserDto> users;

  private Page<ActivityDto> activities;

  private String verificationStatus;

  private Timestamp createdDate;

  private Page<DocumentDto> documents;

  private Page<RequestSummaryDto> clientRequests;
}
