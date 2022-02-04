package com.nttdata.estacionamento.entities;

import com.nttdata.estacionamento.enums.Marca;

import javax.persistence.*;

@Entity
//@MappedSuperclass
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class VehicleEntity {
    @Id
    private String placa;
    private Marca marca;
    private String modelo;
    private Double fatorEstacionamento;
    private String horaEntrada;
    private String horaSaida;
    private Double totalEstacionamento;











}
