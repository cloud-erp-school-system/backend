package org.erp.school.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "document")
public class Document {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  @Column(name = "uri")
  private String uri;

  @Column(name = "file_type")
  private String fileType;

  @Column(name = "file_size")
  private long fileSize;

  @Column(name = "storage")
  private String storageType;

  @Column(name = "created_date")
  private Timestamp createdDate;
}
