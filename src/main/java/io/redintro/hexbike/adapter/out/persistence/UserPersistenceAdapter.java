package io.redintro.hexbike.adapter.out.persistence;

import io.redintro.hexbike.domain.User;
import io.redintro.hexbike.port.out.FindUserPort;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class UserPersistenceAdapter implements FindUserPort {
    private final UserRepository userRepository;

    public UserPersistenceAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository
                .findByUsername(userName)
                .map(UserMapper::mapToDomainEntity)
                .orElseThrow(EntityNotFoundException::new);
    }
}
