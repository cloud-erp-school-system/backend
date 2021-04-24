package org.erp.school.request.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Couldn't find request with supplied id.")
public class RequestNotFoundException extends RuntimeException {
  public RequestNotFoundException(String message) {
    super(message);
  }
}
