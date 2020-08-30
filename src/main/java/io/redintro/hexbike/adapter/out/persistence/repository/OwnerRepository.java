package io.redintro.hexbike.adapter.out.persistence.repository;

import io.redintro.hexbike.adapter.out.persistence.entity.OwnerJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OwnerRepository extends CrudRepository<OwnerJpaEntity, UUID> {
}
