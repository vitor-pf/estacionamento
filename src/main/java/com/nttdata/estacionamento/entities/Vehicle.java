package com.nttdata.estacionamento.entities;

import com.nttdata.estacionamento.enums.Marca;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {
    @Id
    private String placa;
    private Marca marca;
    private String modelo;
    private Double fatorEstacionamento;
    private String horaEntrada;
    private String horaSaida;
    private Double totalEstacionamento;











}
