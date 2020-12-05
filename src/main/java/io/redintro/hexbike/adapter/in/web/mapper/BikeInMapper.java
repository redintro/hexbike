package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.BikeResource;
import io.redintro.hexbike.adapter.in.web.resource.OwnerResource;
import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.domain.Owner;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class BikeInMapper {
   public static Optional<Bike> mapToDomainEntity(BikeResource bike) {
       return Optional.ofNullable(bike)
               .map(b -> Bike.getInstance(
                       b.getId(),
                       b.getMake(),
                       b.getModel(),
                       b.getColour(),
                       b.getYear(),
                       b.getPrice(),
                       Owner.getInstance(
                               b.getOwner().getId(),
                               b.getOwner().getFirstName(),
                               b.getOwner().getLastName())));
    }

    public static Optional<BikeResource> mapToResource(Bike bike) {
        return Optional.ofNullable(bike)
                .map(BikeInMapper::toBikeResource);
    }

    public static List<BikeResource> mapToListResource(List<Bike> bikes) {
       return bikes.stream()
               .filter(Objects::nonNull)
               .map(BikeInMapper::toBikeResource)
               .collect(Collectors.toList());
    }

    private static BikeResource toBikeResource(Bike bike) {
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
