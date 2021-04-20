package org.erp.school.client.child.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private String username;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private String firstName;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private String lastName;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private String phone;

  private boolean primary;
}
