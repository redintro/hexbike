package io.redintro.hexbike.adapter.out.persistence.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "role")
public class RoleJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    public RoleJpaEntity() {
    }

    public RoleJpaEntity(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
