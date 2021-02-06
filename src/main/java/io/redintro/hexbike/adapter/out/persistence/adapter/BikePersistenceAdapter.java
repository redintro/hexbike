package io.redintro.hexbike.adapter.out.persistence.adapter;

import io.redintro.hexbike.adapter.out.persistence.entity.BikeJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.mapper.BikeOutMapper;
import io.redintro.hexbike.adapter.out.persistence.repository.BikeRepository;
import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.port.out.FindBikePort;
import io.vavr.control.Option;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class BikePersistenceAdapter implements FindBikePort {
  private final BikeRepository repository;

  public BikePersistenceAdapter(BikeRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Bike> findAll() {
    List<BikeJpaEntity> bikes = (List<BikeJpaEntity>) repository.findAll();

    return bikes.stream().map(BikeOutMapper::mapToDomainEntity).collect(Collectors.toList());
  }

  @Override
  public Option<Bike> findById(UUID bikeId) {
    return Option.ofOptional(repository.findById(bikeId).map(BikeOutMapper::mapToDomainEntity));
  }
}
