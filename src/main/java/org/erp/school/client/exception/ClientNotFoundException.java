package org.erp.school.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Couldn't find client with supplied id.")
public class ClientNotFoundException extends RuntimeException {
  public ClientNotFoundException(String message) {
    super(message);
  }
}
