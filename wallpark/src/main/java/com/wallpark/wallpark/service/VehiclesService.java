package com.wallpark.wallpark.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.wallpark.wallpark.DTO.CreateVehicleDTO;
import com.wallpark.wallpark.entities.AcaoRealizada;
import com.wallpark.wallpark.entities.UserVehicles;
import com.wallpark.wallpark.entities.Vehicles;
import com.wallpark.wallpark.keys.UserVehicleId;
import com.wallpark.wallpark.repository.UserRepository;
import com.wallpark.wallpark.repository.UserVehiclesRepository;
import com.wallpark.wallpark.repository.VehiclesRepository;

@Service
public class VehiclesService {

    private VehiclesRepository vehiclesRepository;
    private UserRepository userRepository;
    private UserVehiclesRepository userVehiclesRepository;

    public VehiclesService(UserRepository userRepository, 
    UserVehiclesRepository userVehiclesRepository, 
    VehiclesRepository vehiclesRepository) {
        this.userRepository = userRepository;
        this.userVehiclesRepository = userVehiclesRepository;
        this.vehiclesRepository = vehiclesRepository;
    }

    

    public UUID createVehicle(CreateVehicleDTO createVehicleDTO, UUID userId){

        var user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("Usuario não encontrado!"));

        var entity = new Vehicles(UUID.randomUUID(),
                    createVehicleDTO.placa(), 
                    createVehicleDTO.modelo(), 
                    createVehicleDTO.cor(), 
                    createVehicleDTO.vaga(),
                    createVehicleDTO.formaDePagamento());

        var vehicleSaved =  vehiclesRepository.save(entity);

        var userVehicle = new UserVehicles(
            new UserVehicleId(user.getId(), vehicleSaved.getId()),
            user.getFirstName(),
            user.getLastName(),
            AcaoRealizada.ENTRADA,
            LocalDateTime.now(),
            user,
            vehicleSaved
        );

        userVehiclesRepository.save(userVehicle);

        return vehicleSaved.getId();
    }

}
