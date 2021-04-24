package org.erp.school.document;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

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
  private LocalDateTime createdDate;
}
