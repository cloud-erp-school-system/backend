package org.erp.school.client.child.address.contoller;

import io.swagger.annotations.Api;
import org.erp.school.client.child.address.dto.AddressDto;
import org.erp.school.client.child.address.service.AddressService;
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
    return null;
  }

  @GetMapping("client/{clientId}/address/{addressId}")
  public ResponseEntity<AddressDto> getClientAddresses(
      @PathVariable String clientId, @PathVariable String addressId) {
    return null;
  }

  @GetMapping("client/{clientId}/address/primary")
  public ResponseEntity<AddressDto> getPrimaryClientAddresses(@PathVariable String clientId) {
    return null;
  }

  @PostMapping("client/{clientId}/address")
  public ResponseEntity<Void> saveClientAddress(
      @PathVariable String clientId, @RequestBody @Valid AddressDto addressDto) {
    return null;
  }

  @PutMapping("client/{clientId}/address/{addressId}")
  public ResponseEntity<Void> updateClientAddress(
      @PathVariable String clientId,
      @PathVariable String addressId,
      @RequestBody @Valid AddressDto addressDto) {
    return null;
  }

  @DeleteMapping("client/{clientId}/address/{addressId}")
  public ResponseEntity<Void> deleteClientAddresses(
      @PathVariable String clientId, @PathVariable String addressId) {
    return null;
  }
}
