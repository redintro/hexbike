package io.redintro.hexbike.port.in;

import io.redintro.hexbike.domain.Owner;

import java.util.List;
import java.util.UUID;

public interface ShowOwnerPort {
    List<Owner> findAll();
    Owner findById(UUID ownerId);
}
