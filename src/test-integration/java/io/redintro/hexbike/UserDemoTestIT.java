package io.redintro.hexbike;

import io.redintro.hexbike.adapter.out.persistence.entity.RoleJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.entity.UserJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@ActiveProfiles("it")
class UserDemoTestIT extends SharedContainerBase {
    @Autowired
    private UserRepository repository;

    @Test
    void shouldStartContainers() {
        assertThat(POSTGRESQL_CONTAINER.isRunning(), is(equalTo(true)));
    }

    @Test
    void shouldFindAllUsers() {
        List<UserJpaEntity> users = (List<UserJpaEntity>) repository.findAll();

        assertThat(users.size(), is(equalTo(1)));
    }

    @Test
    @Transactional // Keeps the persistence context open so that we can access authorities via user
    void shouldFindAllUserAuthorities() {
        Optional<UserJpaEntity> user = repository.findByUsername("admin");
        Set<RoleJpaEntity> authorities = user.get().getRoles();

        assertThat(user.get().getUsername(), is(equalTo("admin")));
        assertThat(authorities.size(), is(equalTo(1)));
        assertThat(authorities.stream().findFirst().get().getName(), is(equalTo("ADMIN")));
    }
}