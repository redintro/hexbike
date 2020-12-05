package io.redintro.hexbike.adapter.in.web.controller;

import io.redintro.hexbike.adapter.in.web.mapper.BikeInMapper;
import io.redintro.hexbike.adapter.in.web.resource.BikeResource;
import io.redintro.hexbike.port.in.ShowBikePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BikeController {
    private static final String BEARER_TOKEN = "bearer-token";

    private final ShowBikePort showBikePort;

    public BikeController(ShowBikePort showBikePort) {
        this.showBikePort = showBikePort;
    }

    @Operation(security = { @SecurityRequirement(name = BEARER_TOKEN) })
    @GetMapping(value = "/bikes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BikeResource> index() {
       return BikeInMapper.mapToListResource(showBikePort.findAll());
    }

    @Operation(security = { @SecurityRequirement(name = BEARER_TOKEN) })
    @GetMapping(value = "/bikes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BikeResource show(@PathVariable UUID id, Principal principal) {
       return showBikePort.findById(id)
               .flatMap(BikeInMapper::mapToResource)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                       "Cannot find a Bike with the ID: " + id));
    }
}
