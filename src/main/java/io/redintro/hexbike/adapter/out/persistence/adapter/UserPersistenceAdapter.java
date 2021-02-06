package io.redintro.hexbike.adapter.out.persistence.adapter;

import io.redintro.hexbike.adapter.out.persistence.mapper.UserOutMapper;
import io.redintro.hexbike.adapter.out.persistence.repository.UserRepository;
import io.redintro.hexbike.domain.User;
import io.redintro.hexbike.port.out.FindUserPort;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

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
        .map(UserOutMapper::mapToDomainEntity)
        .orElseThrow(EntityNotFoundException::new);
  }
}
