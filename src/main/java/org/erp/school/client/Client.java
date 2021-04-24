package org.erp.school.client;

import lombok.Data;
import org.erp.school.activity.Activity;
import org.erp.school.address.Address;
import org.erp.school.document.contract.Contract;
import org.erp.school.document.Document;
import org.erp.school.request.ClientRequest;
import org.erp.school.user.User;
import org.erp.school.global.enums.SizeCategory;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Client {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  private String name;

  private String website;

  private SizeCategory staffSize;

  private SizeCategory studentSize;

  @OneToMany private Set<Address> address;

  @OneToMany private Set<User> users;

  @OneToMany private Set<Contract> contracts;

  @OneToMany private Set<Activity> activities;

  private String verificationStatus;

  private Timestamp createdDate;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "client_document",
      joinColumns = {@JoinColumn(name = "client_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "document_id", referencedColumnName = "id")})
  private List<Document> documents;

  @OneToMany private Set<ClientRequest> clientRequests;
}
