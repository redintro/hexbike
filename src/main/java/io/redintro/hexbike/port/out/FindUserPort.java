package io.redintro.hexbike.port.out;

import io.redintro.hexbike.domain.User;

public interface FindUserPort {
  User findByUserName(String userName);
}
