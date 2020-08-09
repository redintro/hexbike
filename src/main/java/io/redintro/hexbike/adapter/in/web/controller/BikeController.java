package io.redintro.hexbike.adapter.in.web.controller;

import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.port.in.ShowBikePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BikeController {
    private final ShowBikePort showBikePort;

    public BikeController(ShowBikePort showBikePort) {
        this.showBikePort = showBikePort;
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-token") })
    @GetMapping(value = "/bikes", produces = "application/json")
    public List<Bike> index() {
        return showBikePort.findAll();
    }

    @Operation(security = { @SecurityRequirement(name = "bearer-token") })
    @GetMapping(value = "/bikes/{id}", produces = "application/json")
    public Bike getCar(@PathVariable Long id, Principal principal) {
        assert(principal != null);
        assert(principal.getName().equals("admin"));
        return showBikePort.findById(id);
    }
}
