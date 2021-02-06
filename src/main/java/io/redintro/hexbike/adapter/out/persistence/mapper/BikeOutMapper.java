package io.redintro.hexbike.adapter.out.persistence.mapper;

import io.redintro.hexbike.adapter.out.persistence.entity.BikeJpaEntity;
import io.redintro.hexbike.domain.Bike;

public class BikeOutMapper {
  public static Bike mapToDomainEntity(BikeJpaEntity bike) {
    return Bike.getInstance(
        bike.getId(),
        bike.getOwner().getId(),
        bike.getMake(),
        bike.getModel(),
        bike.getColour(),
        bike.getYear(),
        bike.getPrice());
  }
}
