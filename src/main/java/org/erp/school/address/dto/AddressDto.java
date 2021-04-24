package org.erp.school.address.dto;

import lombok.*;
import org.erp.school.address.Address;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {
  private String id;

  private boolean primary;

  @NotBlank private String street;

  @NotBlank private String postcode;

  @NotBlank private String city;

  @NotBlank private String country;

  public static AddressDto fromEntity(Address address) {
    return AddressDto.builder()
        .id(address.getId())
        .city(address.getCity())
        .country(address.getCountry())
        .postcode(address.getPostcode())
        .primary(address.isPrimary())
        .street(address.getStreet())
        .build();
  }
}
