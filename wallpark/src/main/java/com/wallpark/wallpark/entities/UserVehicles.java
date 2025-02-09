package com.wallpark.wallpark.entities;

import java.time.LocalDateTime;

import com.wallpark.wallpark.keys.UserVehicleId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user_vehicles")
public class UserVehicles {

    @EmbeddedId
    private UserVehicleId id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "acaoRealizada")
    private AcaoRealizada acaoRealizada;

    @Column(name = "horario")
    private LocalDateTime horario;

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("vehiclesId")
    private Vehicles vehicles;

}
