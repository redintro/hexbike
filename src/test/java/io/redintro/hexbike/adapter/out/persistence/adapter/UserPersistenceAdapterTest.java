package io.redintro.hexbike.adapter.out.persistence.adapter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.redintro.hexbike.adapter.out.persistence.entity.RoleJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.entity.UserJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.repository.UserRepository;
import io.redintro.hexbike.domain.User;
import io.vavr.control.Option;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserPersistenceAdapterTest {
  @Mock private UserRepository userRepository;

  @InjectMocks UserPersistenceAdapter userPersistenceAdapter;

  @Test
  public void shouldFindByUserName() {
    final UUID userId = UUID.fromString("9b06bc40-2e96-4259-b880-58bbbd6db38f");
    final UUID roleId = UUID.fromString("134f7041-27b6-414f-807c-4a607e4542f4");

    when(userRepository.findByUsername(any(String.class)))
        .thenReturn(
            Option.of(
                    new UserJpaEntity(
                        userId, "jeff01", "!Password", Set.of(new RoleJpaEntity(roleId, "ADMIN"))))
                .toJavaOptional());

    User user = userPersistenceAdapter.findByUserName("Jeff");

    assertThat(user.getId(), is(equalTo(userId)));
    assertThat(user.getUsername(), is(equalTo("jeff01")));
    assertThat(user.getPassword(), is(equalTo("!Password")));
    assertThat(user.getRoles().size(), is(equalTo(1)));
  }
}
