package io.redintro.hexbike.service;

import io.redintro.hexbike.domain.User;
import io.redintro.hexbike.port.out.FindUserPort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
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
                AuthorityUtils.createAuthorityList(currentUser.getRole()));
    }

    //private org.springframework.security.core.userdetails.User createSpringSecurityUser(User user) {
    //    List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
    //            .map(authority -> new SimpleGrantedAuthority(authority.getName()))
    //            .collect(Collectors.toList());
    //    return new org.springframework.security.core.userdetails.User(user.getUsername(),
    //            user.getPassword(),
    //            grantedAuthorities);
    //}
}
