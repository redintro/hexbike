package io.redintro.hexbike.adapter.in.web.controller;

import io.redintro.hexbike.adapter.in.web.mapper.OwnerInMapper;
import io.redintro.hexbike.adapter.in.web.resource.OwnerResource;
import io.redintro.hexbike.port.in.ShowOwnerPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController()
@RequestMapping("/api")
public class OwnerController {
  private static final String BEARER_TOKEN = "bearer-token";

  private final ShowOwnerPort showOwnerPort;

  public OwnerController(ShowOwnerPort showOwnerPort) {
    this.showOwnerPort = showOwnerPort;
  }

  @Operation(security = {@SecurityRequirement(name = BEARER_TOKEN)})
  @GetMapping(value = "/owners", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<OwnerResource> index() {
    return OwnerInMapper.mapToListRestResource(showOwnerPort.findAll());
  }

  @Operation(security = {@SecurityRequirement(name = BEARER_TOKEN)})
  @GetMapping(value = "/owners/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public OwnerResource show(@PathVariable UUID id) {
    return showOwnerPort
        .findById(id)
        .flatMap(OwnerInMapper::mapToRestResource)
        .getOrElseThrow(
            () ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Cannot find a owner with the ID: " + id));
  }
}
