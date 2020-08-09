package io.redintro.hexbike.adapter.out.persistence;

import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.port.out.FindCarPort;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BikePersistenceAdapter implements FindCarPort {
    private final BikeRepository repository;

    public BikePersistenceAdapter(BikeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Bike> findAll() {
        List<BikeJpaEntity> bikes = (List<BikeJpaEntity>) repository.findAll();

        return bikes
                .stream()
                .map(BikeMapper::mapToDomainEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Bike findById(Long bikeId) {
        return repository.findById(bikeId)
                .map(BikeMapper::mapToDomainEntity)
                .orElseThrow(EntityNotFoundException::new);
    }
}
