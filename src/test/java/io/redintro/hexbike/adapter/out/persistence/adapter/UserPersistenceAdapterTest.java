package io.redintro.hexbike.adapter.out.persistence.adapter;

import io.redintro.hexbike.adapter.out.persistence.entity.RoleJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.entity.UserJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.repository.UserRepository;
import io.redintro.hexbike.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserPersistenceAdapterTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    UserPersistenceAdapter userPersistenceAdapter;

    @Test
    public void shouldFindByUserName() {
        UUID userId = UUID.randomUUID();
        UUID roleId = UUID.randomUUID();

        when(userRepository.findByUsername(any(String.class)))
                .thenReturn(Optional.of(new UserJpaEntity(userId, "jeff01", "!Password",
                       Set.of(new RoleJpaEntity(roleId, "ADMIN")))));

        User user = userPersistenceAdapter.findByUserName("Jeff");

        assertThat(user.getId(), is(equalTo(userId)));
        assertThat(user.getUsername(), is(equalTo("jeff01")));
        assertThat(user.getPassword(), is(equalTo("!Password")));
        assertThat(user.getRoles().size(), is(equalTo(1)));
    }
}