package io.redintro.hexbike.adapter.out.persistence;

import io.redintro.hexbike.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

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
        when(userRepository.findByUsername(any(String.class)))
                .thenReturn(Optional.of(new UserJpaEntity(1L, "jeff01", "!Password",
                        "admin")));

        User user = userPersistenceAdapter.findByUserName("Jeff");

        assertThat(user.getId(), is(equalTo(1L)));
        assertThat(user.getUsername(), is(equalTo("jeff01")));
        assertThat(user.getPassword(), is(equalTo("!Password")));
        assertThat(user.getRole(), is(equalTo("admin")));
    }
}