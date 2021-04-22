package org.erp.school.client.child.address.service.impl;

import org.erp.school.client.child.address.Address;
import org.erp.school.client.child.address.dto.AddressDto;
import org.erp.school.client.child.address.exception.AddressNotFoundException;
import org.erp.school.client.child.address.repository.AddressRepository;
import org.erp.school.client.child.address.service.AddressService;
import org.erp.school.client.exception.ClientNotFoundException;
import org.erp.school.client.repository.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashSet;
import java.util.stream.Collectors;

@Service
public class DefaultAddressService implements AddressService {
  private final AddressRepository addressRepository;
  private final ClientRepository clientRepository;

  public DefaultAddressService(
      AddressRepository addressRepository, ClientRepository clientRepository) {
    this.addressRepository = addressRepository;
    this.clientRepository = clientRepository;
  }

  @Override
  public Page<AddressDto> getAllClientAddresses(String clientId) {
    var client =
        clientRepository
            .findById(clientId)
            .orElseThrow(
                () -> new ClientNotFoundException(clientId));
    return new PageImpl<>(
        client.getAddress().stream().map(AddressDto::fromEntity).collect(Collectors.toList()));
  }

  @Override
  public AddressDto getAddress(String addressId) {
    return AddressDto.fromEntity(
        addressRepository
            .findById(addressId)
            .orElseThrow(
                () ->
                    new AddressNotFoundException( addressId)));
  }

  @Override
  public AddressDto getPrimaryClientAddress(String clientId) {
    return AddressDto.fromEntity(
        clientRepository
            .findById(clientId)
            .orElseThrow(
                () -> new ClientNotFoundException(clientId))
            .getAddress()
            .stream()
            .filter(Address::isPrimary)
            .findFirst()
            .orElseThrow(
                () ->
                    new AddressNotFoundException(clientId)));
  }

  @Override
  public URI saveClientAddress(String clientId, AddressDto dto) {
    var client =
        clientRepository
            .findById(clientId)
            .orElseThrow(
                () -> new ClientNotFoundException(clientId));
    if (dto.isPrimary()) client.getAddress().forEach(element -> element.setPrimary(false));
    var address =
        addressRepository.save(
            Address.builder()
                .country(dto.getCountry())
                .city(dto.getCity())
                .postcode(dto.getPostcode())
                .street(dto.getStreet())
                .primary(dto.isPrimary())
                .build());
    if (client.getAddress() == null) client.setAddress(new HashSet<>());
    client.getAddress().add(address);
    clientRepository.save(client);
    return ServletUriComponentsBuilder.fromCurrentRequest()
        .path("address")
        .buildAndExpand(address.getId())
        .toUri();
  }

  @Override
  public void updateAddress(String clientId, String addressId, AddressDto dto) {
    var client =
        clientRepository
            .findById(clientId)
            .orElseThrow(
                () -> new ClientNotFoundException(clientId));
    if (dto.isPrimary()) client.getAddress().forEach(element -> element.setPrimary(false));
    var address =
        addressRepository.save(
            Address.builder()
                .id(clientId)
                .country(dto.getCountry())
                .city(dto.getCity())
                .postcode(dto.getPostcode())
                .street(dto.getStreet())
                .primary(dto.isPrimary())
                .build());
    if (client.getAddress() == null) client.setAddress(new HashSet<>());
    client.getAddress().add(address);
    clientRepository.save(client);
  }

  @Override
  public void deleteClientAddress(String addressId) {
    addressRepository.deleteById(addressId);
  }
}
