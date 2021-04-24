package org.erp.school.client;

import lombok.Data;
import org.erp.school.activity.Activity;
import org.erp.school.address.Address;
import org.erp.school.document.Document;
import org.erp.school.global.enums.SizeCategory;
import org.erp.school.request.ClientRequest;
import org.erp.school.user.User;
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

  @OneToMany
  @JoinTable(
      name = "client_address",
      joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"))
  private Set<Address> address;

  @OneToMany
  @JoinTable(
      name = "client_user",
      joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "username", referencedColumnName = "id"))
  private Set<User> users;

  private String verificationStatus;

  private Timestamp createdDate;

  @OneToMany
  @JoinTable(
      name = "client_activity",
      joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "activity_id", referencedColumnName = "id"))
  private Set<Activity> activities;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "client_document",
      joinColumns = {@JoinColumn(name = "client_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "document_id", referencedColumnName = "id")})
  private List<Document> documents;

  @OneToMany
  @JoinTable(
      name = "client_request",
      joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "request_id", referencedColumnName = "id"))
  private Set<ClientRequest> clientRequests;
}
