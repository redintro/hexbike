package io.redintro.hexbike.adapter.out.persistence.repository;

import io.redintro.hexbike.adapter.out.persistence.entity.UserJpaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserJpaEntity, Long> {
   Optional<UserJpaEntity> findByUsername(String username);
}
