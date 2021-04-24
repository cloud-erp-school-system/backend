package org.erp.school.activity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.erp.school.activity.enums.ActivityCategory;
import org.erp.school.user.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
  private User createdBy;
}
