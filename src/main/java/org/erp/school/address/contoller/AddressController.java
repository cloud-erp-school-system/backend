package org.erp.school.address.contoller;

import io.swagger.annotations.Api;
import org.erp.school.address.dto.AddressDto;
import org.erp.school.address.service.AddressService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api
public class AddressController {
  private final AddressService addressService;

  public AddressController(AddressService addressService) {
    this.addressService = addressService;
  }

  @GetMapping("client/{clientId}/address")
  public ResponseEntity<Page<AddressDto>> getAllClientAddresses(@PathVariable String clientId) {
    return ResponseEntity.ok(addressService.getAllClientAddresses(clientId));
  }

  @GetMapping("address/{addressId}")
  public ResponseEntity<AddressDto> getAddresses(@PathVariable String addressId) {
    return ResponseEntity.ok(addressService.getAddress(addressId));
  }

  @GetMapping("client/{clientId}/address/primary")
  public ResponseEntity<AddressDto> getPrimaryClientAddresses(@PathVariable String clientId) {
    return ResponseEntity.ok(addressService.getPrimaryClientAddress(clientId));
  }

  @PostMapping("client/{clientId}/address")
  public ResponseEntity<Void> saveClientAddress(
      @PathVariable String clientId, @RequestBody @Valid AddressDto addressDto) {
    return ResponseEntity.created(addressService.saveClientAddress(clientId, addressDto)).build();
  }

  @PutMapping("client/{clientId}/address/{addressId}")
  public ResponseEntity<Void> updateClientAddress(
      @PathVariable String clientId,
      @PathVariable String addressId,
      @RequestBody @Valid AddressDto addressDto) {
    addressService.updateAddress(clientId, addressId, addressDto);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("address/{addressId}")
  public ResponseEntity<Void> deleteClientAddresses(@PathVariable String addressId) {
    addressService.deleteClientAddress(addressId);
    return ResponseEntity.noContent().build();
  }
}
