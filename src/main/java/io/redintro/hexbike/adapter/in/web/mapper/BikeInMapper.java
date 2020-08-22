package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.BikeResource;
import io.redintro.hexbike.adapter.in.web.resource.OwnerResource;
import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.domain.Owner;

public class BikeInMapper {
        public static Bike mapToDomainEntity(BikeResource bike) {
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

    public static BikeResource mapToResource(Bike bike) {
        return new BikeResource(
                bike.getId(),
                bike.getMake(),
                bike.getModel(),
                bike.getColour(),
                bike.getYear(),
                bike.getPrice(),
                new OwnerResource(
                        bike.getOwner().getId(),
                        bike.getOwner().getFirstName(),
                        bike.getOwner().getLastName()));
    }
}
