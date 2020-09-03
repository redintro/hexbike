package io.redintro.hexbike;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

public class ContainerTestBase {
    public static final PostgreSQLContainer<?> POSTGRESQL_CONTAINER;

    static {
        POSTGRESQL_CONTAINER = new PostgreSQLContainer<>("postgres:10")
                .withDatabaseName("hexbike_it")
                .withUsername("docker")
                .withPassword("docker")
                .withExposedPorts(5432)
                .withReuse(true);

        POSTGRESQL_CONTAINER.start();
    }

    @DynamicPropertySource
    public static void registerPgProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", () -> String.format("jdbc:postgresql://localhost:%d/hexbike_it", POSTGRESQL_CONTAINER.getFirstMappedPort()));
        registry.add("spring.datasource.username", () -> "docker");
        registry.add("spring.datasource.password", () -> "docker");
    }
}
