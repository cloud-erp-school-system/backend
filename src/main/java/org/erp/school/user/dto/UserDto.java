package org.erp.school.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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
