package io.redintro.hexbike.adapter.out.persistence;

import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<OwnerJpaEntity, Long> {
}
