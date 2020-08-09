package io.redintro.hexbike.port.in;

import io.redintro.hexbike.domain.Bike;

import java.util.List;

public interface ShowBikePort {
    List<Bike> findAll();
    Bike findById(Long bikeId);
}
