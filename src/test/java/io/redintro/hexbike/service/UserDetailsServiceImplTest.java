package io.redintro.hexbike.service;

import io.redintro.hexbike.domain.User;
import io.redintro.hexbike.port.out.FindUserPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplTest {
    @Mock
    private FindUserPort findUserPort;

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Test
    public void shouldLoadUserByUsername() {
        when(findUserPort.findByUserName(any(String.class)))
                .thenReturn(new User(UUID.randomUUID(), "jeff01", "!Password", "admin"));

        UserDetails userDetails = userDetailsService.loadUserByUsername("jeff01");

        assertThat(userDetails.getUsername(), is(equalTo("jeff01")));
        assertThat(userDetails.getPassword(), is(equalTo("!Password")));
    }
}