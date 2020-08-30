package io.redintro.hexbike.adapter.in.web.controller;

import io.redintro.hexbike.adapter.in.web.mapper.OwnerInMapper;
import io.redintro.hexbike.adapter.in.web.resource.OwnerResource;
import io.redintro.hexbike.domain.Owner;
import io.redintro.hexbike.port.in.ShowOwnerPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/api")
public class OwnerController {
    private static final String BEARER_TOKEN = "bearer-token";
    private static final String APPLICATION_JSON = "application/json";

    private final ShowOwnerPort showOwnerPort;

    public OwnerController(ShowOwnerPort showOwnerPort) {
        this.showOwnerPort = showOwnerPort;
    }

    @Operation(security = { @SecurityRequirement(name = BEARER_TOKEN) })
    @GetMapping(value = "/owners", produces = APPLICATION_JSON)
    public List<OwnerResource> index() {
        List<Owner> owners = showOwnerPort.findAll();
        return owners.stream()
                .map(OwnerInMapper::mapToResource)
                .collect(Collectors.toList());
    }

    @Operation(security = { @SecurityRequirement(name = BEARER_TOKEN) })
    @GetMapping(value = "/owners/{id}", produces = APPLICATION_JSON)
    public OwnerResource show(@PathVariable UUID id) {
        Owner owner = showOwnerPort.findById(id);
        return OwnerInMapper.mapToResource(owner);
    }
}
