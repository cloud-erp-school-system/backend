package org.erp.school.client.child.activity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid activity category")
public class InvalidActivityCategoryException extends RuntimeException {
  public InvalidActivityCategoryException() {}

  public InvalidActivityCategoryException(String message) {
    super(message);
  }
}
