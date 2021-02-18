package io.redintro.hexbike.adapter.out.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "owner")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OwnerJpaEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false, name = "first_name")
  private String firstName;

  @Column(nullable = false, name = "last_name")
  private String lastName;

  @Embedded private AddressJpaEntity address;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
  @JsonIgnore
  private List<BikeJpaEntity> bikes;

  public OwnerJpaEntity() {}

  public OwnerJpaEntity(UUID id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public OwnerJpaEntity(UUID id, String firstName, String lastName, AddressJpaEntity address) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
  }

  public UUID getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public AddressJpaEntity getAddress() {
    return address;
  }
}
