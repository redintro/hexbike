package io.redintro.hexbike.adapter.out.persistence.mapper;

import io.redintro.hexbike.adapter.out.persistence.entity.OwnerJpaEntity;
import io.redintro.hexbike.domain.Owner;

import java.util.stream.Collectors;

public class OwnerOutMapper {
    public static Owner mapToDomainEntity(OwnerJpaEntity owner) {
        return Owner.getInstance(
                owner.getId(),
                owner.getFirstName(),
                owner.getLastName(),
                owner.getBikes().stream()
                        .map(BikeOutMapper::mapToDomainEntity)
                        .collect(Collectors.toList()));
    }
}
