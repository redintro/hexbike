package io.redintro.hexbike.adapter.out.persistence;

import io.redintro.hexbike.domain.Owner;
import io.redintro.hexbike.port.out.FindOwnerPort;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
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
    public Owner findById(Long ownerId) {
        return repository
                .findById(ownerId)
                .map(OwnerOutMapper::mapToDomainEntity)
                .orElseThrow(EntityNotFoundException::new);
    }
}
