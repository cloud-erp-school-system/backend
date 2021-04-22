package org.erp.school.client.child.address.dto;

import lombok.*;
import org.erp.school.client.child.address.Address;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {
  private String id;

  private boolean primary;

  @NotBlank
  private String street;

  @NotBlank
  private String postcode;

  @NotBlank
  private String city;

  @NotBlank
  private String country;

  public static AddressDto fromEntity(Address address) {
    return null;
  }
}
