package io.redintro.hexbike.service;

import io.redintro.hexbike.domain.User;
import io.redintro.hexbike.port.out.FindUserPort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final FindUserPort findUserPort;

    public UserDetailsServiceImpl(FindUserPort findUserPort) {
        this.findUserPort = findUserPort;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User currentUser = findUserPort.findByUserName(username);

        return new org.springframework.security.core.
                userdetails.User(username, currentUser.getPassword(),
                true, true, true, true,
                getAuthorities(currentUser));
    }

    private List<GrantedAuthority> getAuthorities(User user) {
        return user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
