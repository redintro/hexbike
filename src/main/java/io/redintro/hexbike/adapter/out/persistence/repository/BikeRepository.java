package io.redintro.hexbike.adapter.out.persistence.repository;

import io.redintro.hexbike.adapter.out.persistence.entity.BikeJpaEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRepository extends CrudRepository<BikeJpaEntity, UUID> {}
