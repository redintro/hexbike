package io.redintro.hexbike.adapter.out.persistence.mapper;

import io.redintro.hexbike.adapter.out.persistence.entity.OwnerJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.entity.BikeJpaEntity;
import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.domain.Owner;

public class BikeOutMapper {
    public static Bike mapToDomainEntity(BikeJpaEntity bike) {
        return new Bike(
                bike.getId(),
                bike.getMake(),
                bike.getModel(),
                bike.getColour(),
                bike.getYear(),
                bike.getPrice(),
                new Owner(
                        bike.getOwner().getId(),
                        bike.getOwner().getFirstName(),
                        bike.getOwner().getLastName()));
    }

    public static BikeJpaEntity mapToJpaEntity(Bike bike) {
        return new BikeJpaEntity(
                bike.getId(),
                bike.getMake(),
                bike.getModel(),
                bike.getColour(),
                bike.getYear(),
                bike.getPrice(),
                    new OwnerJpaEntity(
                            bike.getOwner().getId(),
                            bike.getOwner().getFirstName(),
                            bike.getOwner().getLastName()));
    }
}
