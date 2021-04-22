package org.erp.school.client.child.address.service;

import org.erp.school.client.child.address.dto.AddressDto;
import org.springframework.data.domain.Page;

import java.net.URI;

public interface AddressService {
  Page<AddressDto> getAllClientAddresses(String clientId);

  AddressDto getAddress(String addressId);

  AddressDto getPrimaryClientAddress(String clientId);

  URI saveClientAddress(String clientId, AddressDto dto);

  void updateAddress(String clientId,String addressId, AddressDto dto);

  void deleteClientAddress(String addressId);
}
