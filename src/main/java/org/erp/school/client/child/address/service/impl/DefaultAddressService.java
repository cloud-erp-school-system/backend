package org.erp.school.client.child.address.service.impl;

import org.erp.school.client.child.address.dto.AddressDto;
import org.erp.school.client.child.address.repository.AddressRepository;
import org.erp.school.client.child.address.service.AddressService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class DefaultAddressService implements AddressService {
    private final AddressRepository addressRepository;

    public DefaultAddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Page<AddressDto> getAllClientAddresses(String clientId) {
        return null;
    }

    @Override
    public AddressDto getClientAddress(String clientId, String addressId) {
        return null;
    }

    @Override
    public AddressDto getPrimaryClientAddress(String clientId) {
        return null;
    }

    @Override
    public void saveClientAddress(String clientId, AddressDto dto) {

    }

    @Override
    public void updateClientAddress(String clientId,
                                    String addressId,
                                    AddressDto dto) {

    }

    @Override
    public void deleteClientAddress(String clientId, String addressId) {

    }
}
