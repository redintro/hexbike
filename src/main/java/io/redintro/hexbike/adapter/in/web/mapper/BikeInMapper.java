package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.BikeResource;
import io.redintro.hexbike.adapter.in.web.resource.OwnerResource;
import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.domain.Owner;
import io.vavr.Value;
import io.vavr.control.Option;
import io.vavr.control.Try;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BikeInMapper {
   public static Option<Bike> mapToDomainEntity(BikeResource bikeResource) {
      return BikeInMapper.toDomainEntity(bikeResource).toOption();
    }

    public static Option<BikeResource> mapToRestResource(Bike bike) {
       return BikeInMapper.toRestResource(bike).toOption();
    }

    public static List<BikeResource> mapToListRestResource(List<Bike> bikes) {
        return Try.of(() ->
                bikes.stream()
                        .map(BikeInMapper::toRestResource)
                        .flatMap(Value::toJavaStream)
                        .collect(Collectors.toList()))
                .getOrElse(Collections::emptyList);
    }

    public static Option<Bike> toDomainEntity(BikeResource bike) {
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
                .toOption();
    }

    private static Try<BikeResource> toRestResource(Bike bike) {
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
                                bike.getOwner().getLastName())));
    }
}
