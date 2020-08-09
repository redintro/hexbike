package io.redintro.hexbike.service;

import io.redintro.hexbike.domain.User;
import io.redintro.hexbike.port.out.FindUserPort;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final FindUserPort findUserPort;

    public UserDetailsServiceImpl(FindUserPort findUserPort) {
        this.findUserPort = findUserPort;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User currentUser = findUserPort.findByUserName(username);

        return new org.springframework.security.core.
                userdetails.User(username, currentUser.getPassword(),
                true, true, true, true,
                AuthorityUtils.createAuthorityList(currentUser.getRole()));
    }
}
