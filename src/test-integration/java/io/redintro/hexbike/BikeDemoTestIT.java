package io.redintro.hexbike;

import io.redintro.hexbike.adapter.out.persistence.entity.BikeJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.repository.BikeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@ActiveProfiles("it")
class BikeDemoTestIT extends ContainerTestBase {
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
