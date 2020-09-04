package io.redintro.hexbike.adapter.out.persistence.adapter;

import io.redintro.hexbike.adapter.out.persistence.repository.OwnerRepository;
import io.redintro.hexbike.adapter.out.persistence.entity.OwnerJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.mapper.OwnerOutMapper;
import io.redintro.hexbike.domain.Owner;
import io.redintro.hexbike.port.out.FindOwnerPort;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OwnerPersistenceAdapter implements FindOwnerPort {
    private final OwnerRepository repository;

    public OwnerPersistenceAdapter(OwnerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Owner> findAll() {
        List<OwnerJpaEntity> owners = (List<OwnerJpaEntity>) repository.findAll();

        return owners
                .stream()
                .map(OwnerOutMapper::mapToDomainEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Owner> findById(UUID ownerId) {
        return repository
                .findById(ownerId)
                .map(OwnerOutMapper::mapToDomainEntity);
    }
}
