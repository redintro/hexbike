package io.redintro.hexbike.service;

import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.port.in.ShowBikePort;
import io.redintro.hexbike.port.out.FindCarPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowBikeService implements ShowBikePort {
    private final FindCarPort findCarPort;

    public ShowBikeService(FindCarPort findCarPort) {
        this.findCarPort = findCarPort;
    }

    @Override
    public List<Bike> findAll() {
        return findCarPort.findAll();
    }

    @Override
    public Bike findById(Long bikeId) {
        return findCarPort.findById(bikeId);
    }
}
