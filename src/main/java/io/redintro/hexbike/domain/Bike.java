package io.redintro.hexbike.domain;

public class Bike {
    private final Long id;
    private final String make;
    private final String model;
    private final String colour;
    private final int year;
    private final int price;
    private final Owner owner;

    public Bike(Long id, String make, String model, String colour, int year, int price,
                Owner owner) {
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

    public Owner getOwner() {
        return owner;
    }
}
