package io.redintro.hexbike.port.out;

import io.redintro.hexbike.domain.Owner;

import java.util.List;

public interface FindOwnerPort {
    List<Owner> findAll();
    Owner findById(Long ownerId);
}
