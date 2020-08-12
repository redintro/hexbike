package io.redintro.hexbike.port.out;

import io.redintro.hexbike.domain.Bike;

import java.util.List;

public interface FindBikePort {
    List<Bike> findAll();
    Bike findById(Long bikeId);
}
