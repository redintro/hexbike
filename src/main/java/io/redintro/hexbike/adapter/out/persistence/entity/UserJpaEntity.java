package io.redintro.hexbike.adapter.out.persistence.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "`user`") // user is a reserved word in postgresql
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

    public UserJpaEntity() {
    }

    public UserJpaEntity(UUID id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
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
}
