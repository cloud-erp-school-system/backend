package org.erp.school.client.child.address.dto;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {
  private String id;

  private boolean primary;

  private String street;

  private String postcode;

  private String city;

  private String country;
}
