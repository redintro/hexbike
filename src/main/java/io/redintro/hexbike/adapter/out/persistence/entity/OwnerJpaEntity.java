package io.redintro.hexbike.adapter.out.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.redintro.hexbike.adapter.out.persistence.entity.BikeJpaEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "owner")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OwnerJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, name= "first_name")
    private String firstName;
    @Column(nullable = false, name = "last_name")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    @JsonIgnore
    private List<BikeJpaEntity> bikes;

    public OwnerJpaEntity() {
    }

    public OwnerJpaEntity(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<BikeJpaEntity> getBikes() {
        return bikes;
    }
}
