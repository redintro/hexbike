package io.redintro.hexbike.port.out;

import io.redintro.hexbike.domain.Bike;
import io.vavr.control.Option;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FindBikePort {
    List<Bike> findAll();
    Option<Bike> findById(UUID bikeId);
}
