package io.redintro.hexbike.port.in;

import io.redintro.hexbike.domain.Bike;

import java.util.List;
import java.util.UUID;

public interface ShowBikePort {
    List<Bike> findAll();
    Bike findById(UUID bikeId);
}
