package io.redintro.hexbike.adapter.in.web.controller;

import io.redintro.hexbike.adapter.in.web.mapper.BikeInMapper;
import io.redintro.hexbike.adapter.in.web.resource.BikeResource;
import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.port.in.ShowBikePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BikeController {
    private static final String BEARER_TOKEN = "bearer-token";
    private static final String APPLICATION_JSON = "application/json";

    private final ShowBikePort showBikePort;

    public BikeController(ShowBikePort showBikePort) {
        this.showBikePort = showBikePort;
    }

    @Operation(security = { @SecurityRequirement(name = BEARER_TOKEN) })
    @GetMapping(value = "/bikes", produces = APPLICATION_JSON)
    public List<BikeResource> index() {
        List<Bike> bikes = showBikePort.findAll();
        return bikes.stream()
                .map(BikeInMapper::mapToResource)
                .collect(Collectors.toList());
    }

    @Operation(security = { @SecurityRequirement(name = BEARER_TOKEN) })
    @GetMapping(value = "/bikes/{id}", produces = APPLICATION_JSON)
    public BikeResource show(@PathVariable UUID id, Principal principal) {
        try {
            Bike bike = showBikePort.findById(id);
            return BikeInMapper.mapToResource(bike);
        } catch(EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find a bike with the ID: " + id);
        }
    }
}
