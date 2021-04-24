package org.erp.school.address.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Couldn't find address with supplied id.")
public class AddressNotFoundException extends RuntimeException {
  public AddressNotFoundException(String id) {
    super("Could not find address with id: " + id);
  }
}
