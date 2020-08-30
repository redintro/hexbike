package io.redintro.hexbike.port.out;

import io.redintro.hexbike.domain.Bike;

import java.util.List;
import java.util.UUID;

public interface FindBikePort {
    List<Bike> findAll();
    Bike findById(UUID bikeId);
}
