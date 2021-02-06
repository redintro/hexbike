package io.redintro.hexbike.adapter.out.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "`user`") // '`' required as 'user' is a reserved word in postgresql
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserJpaEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(nullable = false, updatable = false)
  private UUID id;

  @Column(nullable = false, unique = true, name = "user_name")
  private String username;

  @Column(nullable = false)
  private String password;

  @JsonIgnore
  @ManyToMany
  @JoinTable(
      name = "user_role",
      joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
  private Set<RoleJpaEntity> roles = new HashSet<>();

  public UserJpaEntity() {}

  public UserJpaEntity(UUID id, String username, String password, Set<RoleJpaEntity> roles) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.roles = roles;
  }

  public UUID getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public Set<RoleJpaEntity> getRoles() {
    return roles;
  }
}
