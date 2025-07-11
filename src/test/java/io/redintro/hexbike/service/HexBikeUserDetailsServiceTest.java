package io.redintro.hexbike.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.redintro.hexbike.domain.Role;
import io.redintro.hexbike.domain.User;
import io.redintro.hexbike.port.out.FindUserPort;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

@ExtendWith(MockitoExtension.class)
class HexBikeUserDetailsServiceTest {
  @Mock private FindUserPort findUserPort;

  @InjectMocks private HexBikeUserDetailsService userDetailsService;

  @Test
  public void shouldLoadUserByUsername() {
    when(findUserPort.findByUserName(any(String.class)))
        .thenReturn(
            User.getInstance(
                UUID.randomUUID(),
                "jeff01",
                "!Password",
                Set.of(Role.getInstance(UUID.randomUUID(), "ADMIN"))));

    UserDetails userDetails = userDetailsService.loadUserByUsername("jeff01");

    assertThat(userDetails.getUsername(), is(equalTo("jeff01")));
    assertThat(userDetails.getPassword(), is(equalTo("!Password")));
  }
}
