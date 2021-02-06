package io.redintro.hexbike.port.in;

import io.redintro.hexbike.domain.Bike;
import io.vavr.control.Option;
import java.util.List;
import java.util.UUID;

public interface ShowBikePort {
  List<Bike> findAll();

  Option<Bike> findById(UUID bikeId);
}
