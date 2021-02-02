package io.redintro.hexbike.port.out;

import io.redintro.hexbike.domain.Owner;
import io.vavr.control.Option;

import java.util.List;
import java.util.UUID;

public interface FindOwnerPort {
    List<Owner> findAll();
    Option<Owner> findById(UUID ownerId);
}
