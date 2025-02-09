package com.wallpark.wallpark.keys;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserVehicleId implements Serializable{

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "vehicles_id")
    private UUID vehiclesId;

    public UserVehicleId() {}

    public UserVehicleId(UUID userId, UUID vehicleId) {
        this.userId = userId;
        this.vehiclesId = vehicleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, vehiclesId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UserVehicleId other = (UserVehicleId) obj;
        return Objects.equals(userId, other.userId) &&
               Objects.equals(vehiclesId, other.vehiclesId);
    }

}
