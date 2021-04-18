package org.erp.school.client.child.user.dto;

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
    private String username;

    private String firstName;

    private String lastName;

    private String phone;

    private boolean primary;
}
