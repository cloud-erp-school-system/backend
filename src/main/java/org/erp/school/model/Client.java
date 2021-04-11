package org.erp.school.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "client")
public class Client {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  @Column(name = "name")
  private String name;

  @OneToOne private Address address;

  @Column(name = "verification_status")
  private String verificationStatus;

  @Column(name = "created_date")
  private Timestamp createdDate;

  @OneToMany
  @JoinTable(
      name = "client_document",
      joinColumns = {@JoinColumn(name = "client_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "document_id", referencedColumnName = "id")})
  private List<Document> documents;
}
