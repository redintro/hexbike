package io.redintro.hexbike.adapter.out.persistence;

import io.redintro.hexbike.domain.Owner;

public class OwnerOutMapper {
    public static Owner mapToDomainEntity(OwnerJpaEntity owner) {
        return new Owner(
                owner.getId(),
                owner.getFirstName(),
                owner.getLastName());
    }

    public static OwnerJpaEntity mapToJpaEntity(Owner owner) {
        return new OwnerJpaEntity(
                owner.getId(),
                owner.getFirstName(),
                owner.getLastName());
    }
}
