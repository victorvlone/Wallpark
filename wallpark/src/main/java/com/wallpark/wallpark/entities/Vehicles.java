package com.wallpark.wallpark.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicles {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "placa")
    private String placa;

    @Column(name = "modelo")
    private String modelo;
    
    @Column(name = "cor")
    private String cor;

    @Column(name = "vaga")
    private String vaga;

    @Column(name = "formadePagamento")
    private String formadePagamento;

}
