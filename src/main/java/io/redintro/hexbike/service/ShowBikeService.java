package io.redintro.hexbike.service;

import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.port.in.ShowBikePort;
import io.redintro.hexbike.port.out.FindBikePort;
import io.vavr.control.Option;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShowBikeService implements ShowBikePort {
    private final FindBikePort findBikePort;

    public ShowBikeService(FindBikePort findBikePort) {
        this.findBikePort = findBikePort;
    }

    @Override
    public List<Bike> findAll() {
        return findBikePort.findAll();
    }

    @Override
    public Option<Bike> findById(UUID bikeId) {
        return findBikePort.findById(bikeId);
    }
}
