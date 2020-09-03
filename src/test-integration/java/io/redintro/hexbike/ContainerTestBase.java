package io.redintro.hexbike;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

/*
 * A static initializer to create a shared database container for reuse across tests. Used in place of the JUnit 5
 * @Testcontainers annotation to avoid having to set the testcontainers.reuse.enable=true property a local
 * ~/.testcontainers.properties file.
 */
public abstract class ContainerTestBase {
    static final PostgreSQLContainer<?> POSTGRESQL_CONTAINER;

    static {
        POSTGRESQL_CONTAINER = new PostgreSQLContainer<>("postgres:10")
                .withDatabaseName("hexbike_it")
                .withUsername("docker")
                .withPassword("docker")
                .withReuse(true);

        POSTGRESQL_CONTAINER.start();
    }

    @DynamicPropertySource
    static void datasourceConfig(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", POSTGRESQL_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", POSTGRESQL_CONTAINER::getUsername);
        registry.add("spring.datasource.password", POSTGRESQL_CONTAINER::getPassword);
    }
}
