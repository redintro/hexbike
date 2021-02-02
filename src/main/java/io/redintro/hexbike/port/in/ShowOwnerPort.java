package io.redintro.hexbike.port.in;

import io.redintro.hexbike.domain.Owner;
import io.vavr.control.Option;

import java.util.List;
import java.util.UUID;

public interface ShowOwnerPort {
    List<Owner> findAll();
    Option<Owner> findById(UUID ownerId);
}
