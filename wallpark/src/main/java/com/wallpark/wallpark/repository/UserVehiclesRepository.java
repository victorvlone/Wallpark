package com.wallpark.wallpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wallpark.wallpark.entities.UserVehicles;
import com.wallpark.wallpark.keys.UserVehicleId;

@Repository
public interface UserVehiclesRepository extends JpaRepository<UserVehicles, UserVehicleId>{

}
