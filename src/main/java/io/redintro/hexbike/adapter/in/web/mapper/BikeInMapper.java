package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.BikeResource;
import io.redintro.hexbike.adapter.in.web.resource.OwnerResource;
import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.domain.Owner;
import io.vavr.control.Try;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BikeInMapper {
   public static Optional<Bike> mapToDomainEntity(BikeResource bikeResource) {
      return BikeInMapper.toDomainEntity(bikeResource);
    }

    public static Optional<BikeResource> mapToRestResource(Bike bike) {
       return BikeInMapper.toRestResource(bike);
    }

    public static List<BikeResource> mapToListRestResource(List<Bike> bikes) {
        return Try.of(() ->
                bikes.stream()
                        .map(BikeInMapper::mapToRestResource)
                        .flatMap(Optional::stream)
                        .collect(Collectors.toList()))
                .getOrElse(Collections::emptyList);
    }

    public static Optional<Bike> toDomainEntity(BikeResource bike) {
        return Try.of(() ->
                Bike.getInstance(
                        bike.getId(),
                        bike.getMake(),
                        bike.getModel(),
                        bike.getColour(),
                        bike.getYear(),
                        bike.getPrice(),
                        Owner.getInstance(
                                bike.getOwner().getId(),
                                bike.getOwner().getFirstName(),
                                bike.getOwner().getLastName())))
                .toJavaOptional();
    }

    private static Optional<BikeResource> toRestResource(Bike bike) {
        return Try.of(() ->
                new BikeResource(
                        bike.getId(),
                        bike.getMake(),
                        bike.getModel(),
                        bike.getColour(),
                        bike.getYear(),
                        bike.getPrice(),
                        new OwnerResource(
                                bike.getOwner().getId(),
                                bike.getOwner().getFirstName(),
                                bike.getOwner().getLastName())))
                .toJavaOptional();
    }
}
