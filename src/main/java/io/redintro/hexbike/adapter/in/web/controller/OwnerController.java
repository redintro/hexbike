package io.redintro.hexbike.adapter.in.web.controller;

import io.redintro.hexbike.domain.Owner;
import io.redintro.hexbike.port.in.ShowOwnerPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class OwnerController {
    private final ShowOwnerPort showOwnerPort;

    public OwnerController(ShowOwnerPort showOwnerPort) {
        this.showOwnerPort = showOwnerPort;
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-token") })
    @GetMapping(value = "/owners", produces = "application/json")
    public List<Owner> index() {
        return showOwnerPort.findAll();
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-token") })
    @GetMapping(value = "/owners/{id}", produces = "application/json")
    public Owner show(@PathVariable long id) {
        return showOwnerPort.findById(id);
    }
}
