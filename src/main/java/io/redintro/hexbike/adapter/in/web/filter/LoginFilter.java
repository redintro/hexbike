package io.redintro.hexbike.adapter.in.web.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.redintro.hexbike.adapter.in.web.mapper.AccountCredentialsInMapper;
import io.redintro.hexbike.adapter.in.web.resource.AccountCredentialsResource;
import io.redintro.hexbike.domain.AccountCredentials;
import io.redintro.hexbike.service.AuthenticationService;
import java.io.IOException;
import java.util.Collections;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {
  public LoginFilter(String url, AuthenticationManager authManager) {
    super(new AntPathRequestMatcher(url));
    setAuthenticationManager(authManager);
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
      throws AuthenticationException, IOException, ServletException {

    AccountCredentialsResource credentialsResource =
        new ObjectMapper().readValue(req.getInputStream(), AccountCredentialsResource.class);

    AccountCredentials credentials =
        AccountCredentialsInMapper.mapToDomainEntity(credentialsResource);

    return getAuthenticationManager()
        .authenticate(
            new UsernamePasswordAuthenticationToken(
                credentials.getUsername(), credentials.getPassword(), Collections.emptyList()));
  }

  @Override
  protected void successfulAuthentication(
      HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) {
    AuthenticationService.addToken(res, auth.getName());
  }
}
