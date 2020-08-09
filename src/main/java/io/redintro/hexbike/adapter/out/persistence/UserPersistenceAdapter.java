package io.redintro.hexbike.adapter.out.persistence;

import io.redintro.hexbike.domain.User;
import io.redintro.hexbike.port.out.FindUserPort;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class UserPersistenceAdapter implements FindUserPort {
    private final UserRepository repository;

    public UserPersistenceAdapter(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findByUserName(String userName) {
        return repository
                .findByUsername(userName)
                .map(UserMapper::mapToDomainEntity)
                .orElseThrow(EntityNotFoundException::new);
    }
}
