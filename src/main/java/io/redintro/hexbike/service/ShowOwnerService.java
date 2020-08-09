package io.redintro.hexbike.service;

import io.redintro.hexbike.domain.Owner;
import io.redintro.hexbike.port.in.ShowOwnerPort;
import io.redintro.hexbike.port.out.FindOwnerPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowOwnerService implements ShowOwnerPort {
    private final FindOwnerPort findOwnerPort;

    public ShowOwnerService(FindOwnerPort findOwnerPort) {
        this.findOwnerPort = findOwnerPort;
    }

    @Override
    public List<Owner> findAll() {
        return findOwnerPort.findAll();
    }

    @Override
    public Owner findById(Long ownerId) {
        return findOwnerPort.findById(ownerId);
    }
}
