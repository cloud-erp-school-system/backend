package org.erp.school.client.child.address.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Couldn't find address with supplied id.")
public class AddressNotFoundException extends RuntimeException {
  public AddressNotFoundException(String message) {
    super(message);
  }
}
