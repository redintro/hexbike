package io.redintro.hexbike;

import io.redintro.hexbike.adapter.out.persistence.entity.BikeJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.repository.BikeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@Testcontainers
@ActiveProfiles("it")
class BikeDemoTestIT {
	@Container
	public static final PostgreSQLContainer<?> POSTGRESQL_CONTAINER = new PostgreSQLContainer<>("postgres:10")
			.withDatabaseName("hexbike_it")
			.withUsername("docker")
			.withPassword("docker")
			.withExposedPorts(5432)
			.withReuse(true);

	@DynamicPropertySource
	public static void registerPgProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", () -> String.format("jdbc:postgresql://localhost:%d/hexbike_it", POSTGRESQL_CONTAINER.getFirstMappedPort()));
		registry.add("spring.datasource.username", () -> "docker");
		registry.add("spring.datasource.password", () -> "docker");
	}

	@Autowired
	private BikeRepository repository;

	@Test
	void shouldStartContainers() {
		assertThat(POSTGRESQL_CONTAINER.isRunning(), is(equalTo(true)));
	}

	@Test
	void shouldFindAllBikes() {
		List<BikeJpaEntity> bikes = (List<BikeJpaEntity>) repository.findAll();
		assertThat(bikes.size(), is(equalTo(1)));
	}
}
