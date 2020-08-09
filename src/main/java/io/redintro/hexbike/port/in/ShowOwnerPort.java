package io.redintro.hexbike.port.in;

import io.redintro.hexbike.domain.Owner;

import java.util.List;

public interface ShowOwnerPort {
    List<Owner> findAll();
    Owner findById(Long ownerId);
}
