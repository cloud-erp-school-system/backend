package org.erp.school.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    private String username;

    private String firstName;

    private String lastName;

    private String phone;

    private boolean primary;
}
