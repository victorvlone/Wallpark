package com.wallpark.wallpark.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wallpark.wallpark.entities.Vehicles;

@Repository
public interface VehiclesRepository extends JpaRepository<Vehicles, UUID>{

}
