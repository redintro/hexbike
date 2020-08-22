package io.redintro.hexbike.adapter.in.web.filter;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.FilterChain;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoginFilterTest {
    @Mock
    AuthenticationManager authenticationManager;

    private MockHttpServletRequest request;

    private MockHttpServletResponse response;

    @BeforeEach
    public void setUp() {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void attemptAuthentication() throws Exception {
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(new UsernamePasswordAuthenticationToken("admin", "!Password",
                        Collections.emptyList()));

        String accountCredentialsResource =
                "{ " +
                    "\"username\" : \"jeffo1\", " +
                    "\"password\" : \"!Password\" " +
                "}";

        request.setContent(IOUtils.toByteArray(IOUtils.toInputStream(accountCredentialsResource, "UTF-8")));

        LoginFilter loginFilter = new LoginFilter("/api/bikes", authenticationManager);

        Authentication authentication = loginFilter.attemptAuthentication(request, response);

        assertThat(authentication, is(notNullValue()));
        assertThat(authentication.getName(), is(equalTo("admin")));
    }

    @Test
    public void successfulAuthentication() {
        LoginFilter loginFilter = spy(new LoginFilter("/api/bikes", authenticationManager));

        FilterChain filterChain = mock(FilterChain.class);

        Authentication authentication = new UsernamePasswordAuthenticationToken("admin", "!Password",
                Collections.emptyList());

        loginFilter.successfulAuthentication(request, response, filterChain, authentication);

        verify(loginFilter, times(1)).successfulAuthentication(request, response, filterChain, authentication);
    }
}