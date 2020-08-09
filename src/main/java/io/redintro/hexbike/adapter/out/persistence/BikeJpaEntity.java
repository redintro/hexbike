package io.redintro.hexbike.adapter.out.persistence;

import javax.persistence.*;

@Entity
@Table(name = "bike")
public class BikeJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String make;
    private String model;
    private String colour;
    private int year;
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private OwnerJpaEntity owner;

    public BikeJpaEntity() {
    }

    public BikeJpaEntity(Long id, String make, String model, String colour, int year, int price, OwnerJpaEntity owner) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.year = year;
        this.price = price;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public OwnerJpaEntity getOwner() {
        return owner;
    }
}
