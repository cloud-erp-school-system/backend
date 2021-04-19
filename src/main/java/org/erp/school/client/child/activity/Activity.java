package org.erp.school.client.child.activity;

import lombok.Data;
import org.erp.school.client.child.activity.enums.ActivityCategory;
import org.erp.school.client.child.user.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class Activity {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  private ActivityCategory category;

  private String referencing;

  private String shortDescription;

  private String description;

  @CreationTimestamp
  private Timestamp created;

  @OneToOne
  private User by;
}
