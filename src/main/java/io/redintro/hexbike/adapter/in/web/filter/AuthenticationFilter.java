package io.redintro.hexbike.adapter.in.web.filter;

import io.redintro.hexbike.service.AuthenticationService;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class AuthenticationFilter extends GenericFilterBean {
  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
      throws IOException, ServletException {
    Authentication authentication =
        AuthenticationService.getAuthentication((HttpServletRequest) req);

    SecurityContextHolder.getContext().setAuthentication(authentication);

    filterChain.doFilter(req, res);
  }
}
