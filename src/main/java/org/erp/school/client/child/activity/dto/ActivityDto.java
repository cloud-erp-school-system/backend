package org.erp.school.client.child.activity.dto;

import lombok.*;
import org.erp.school.client.child.activity.enums.ActivityCategory;
import org.erp.school.client.child.user.User;
import org.erp.school.client.child.user.dto.UserDto;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ActivityDto {

  private String id;


  private ActivityCategory category;

  private String referencing;

  private String shortDescription;

  private String description;

  private Timestamp timestamp;

  private UserDto by;
}
