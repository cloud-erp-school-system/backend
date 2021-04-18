package org.erp.school.client.child.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.erp.school.client.child.request.enums.RequestStatus;
import org.erp.school.client.Client;
import org.erp.school.client.child.request.enums.RequestType;
import org.erp.school.client.child.user.User;
import org.erp.school.global.enums.SizeCategory;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class ClientRequest {

  @Id
  @GenericGenerator(name = "req_sequence", strategy = "org.erp.school.client.child.request.util.RequestNumberGenerator")
  @GeneratedValue(generator = "req_sequence")
  private String id;

  @OneToOne
  private User caller;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "client_id", referencedColumnName = "id")
  private Client client;

  @Enumerated(EnumType.STRING)
  private RequestStatus status;

  private RequestType type;

  private SizeCategory studentLicense;

  private SizeCategory parentLicense;

  private SizeCategory academicLicense;
}
