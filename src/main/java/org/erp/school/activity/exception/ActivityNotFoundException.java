package org.erp.school.activity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Couldn't find activity with supplied id.")
public class ActivityNotFoundException extends RuntimeException {
  public ActivityNotFoundException(String message) {
    super(message);
  }
}
