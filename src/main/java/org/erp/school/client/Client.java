package org.erp.school.client;

import lombok.Data;
import org.erp.school.client.child.activity.Activity;
import org.erp.school.client.child.address.Address;
import org.erp.school.client.child.user.User;
import org.erp.school.client.child.contract.Contract;
import org.erp.school.client.child.document.Document;
import org.erp.school.client.child.request.ClientRequest;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

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

  @OneToMany private Set<User> users;

  @OneToMany private Set<Contract> contracts;

  @OneToMany private Set<Activity> activities;

  @Column(name = "verification_status")
  private String verificationStatus;

  @Column(name = "created_date")
  private Timestamp createdDate;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinTable(
          name = "client_document",
          joinColumns = {@JoinColumn(name = "client_id", referencedColumnName = "id")},
          inverseJoinColumns = {@JoinColumn(name = "document_id", referencedColumnName = "id")})
  private List<Document> documents;

  @OneToOne(mappedBy = "client")
  private ClientRequest clientRequest;
}
