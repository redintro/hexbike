package io.redintro.hexbike.adapter.out.persistence.repository;

import io.redintro.hexbike.adapter.out.persistence.entity.OwnerJpaEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<OwnerJpaEntity, UUID> {}
