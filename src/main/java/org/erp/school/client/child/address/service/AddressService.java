package org.erp.school.client.child.address.service;

import org.erp.school.client.child.activity.dto.ActivityDto;
import org.erp.school.client.child.address.dto.AddressDto;
import org.springframework.data.domain.Page;

public interface AddressService {
  Page<AddressDto> getAllClientAddresses(String clientId);

  AddressDto getClientAddress(String clientId, String addressId);

  AddressDto getPrimaryClientAddress(String clientId);

  void saveClientAddress(String clientId, AddressDto dto);

  void updateClientAddress(String clientId, String addressId, AddressDto dto);

  void deleteClientAddress(String clientId, String addressId);
}
