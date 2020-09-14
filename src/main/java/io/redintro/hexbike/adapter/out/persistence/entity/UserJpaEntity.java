package io.redintro.hexbike.adapter.out.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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

    @Column(nullable = false)
    private String role;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    private Set<AuthorityJpaEntity> authorities = new HashSet<>();

    public UserJpaEntity() {
    }

    public UserJpaEntity(UUID id, String username, String password, String role, Set<AuthorityJpaEntity> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.authorities = authorities;
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

    public String getRole() {
        return role;
    }

    public Set<AuthorityJpaEntity> getAuthorities() {
        return authorities;
    }
}
