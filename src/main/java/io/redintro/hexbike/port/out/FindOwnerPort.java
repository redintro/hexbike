package io.redintro.hexbike.port.out;

import io.redintro.hexbike.domain.Owner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FindOwnerPort {
    List<Owner> findAll();
    Optional<Owner> findById(UUID ownerId);
}
