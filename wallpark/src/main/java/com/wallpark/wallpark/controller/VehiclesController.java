package com.wallpark.wallpark.controller;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallpark.wallpark.DTO.CreateVehicleDTO;
import com.wallpark.wallpark.entities.Vehicles;
import com.wallpark.wallpark.service.VehiclesService;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {

    private VehiclesService vehiclesService;

    public VehiclesController(VehiclesService vehiclesService) {
        this.vehiclesService = vehiclesService;
    }

    @PostMapping
    public ResponseEntity<Void> createVehicle(@RequestBody CreateVehicleDTO createVehicleDTO, @AuthenticationPrincipal Jwt jwt){
        UUID userId = UUID.fromString(jwt.getClaim("userid"));
        var vehicleId= vehiclesService.createVehicle(createVehicleDTO, userId);
        return ResponseEntity.created(URI.create("/vehicles/" + vehicleId.toString())).build();
    }

    @GetMapping("{/id}")
    public ResponseEntity<Vehicles> getVehicleById(){
        return null;
    }
}
