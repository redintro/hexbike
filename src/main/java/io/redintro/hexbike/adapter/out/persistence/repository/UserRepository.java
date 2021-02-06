package io.redintro.hexbike.adapter.out.persistence.repository;

import io.redintro.hexbike.adapter.out.persistence.entity.UserJpaEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserJpaEntity, UUID> {
  Optional<UserJpaEntity> findByUsername(String username);
}
