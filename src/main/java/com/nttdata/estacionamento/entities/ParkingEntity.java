package com.nttdata.estacionamento.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ParkingEntity {
    @Id
    private Long id;
    private Double valorHora;
    private Double totalFaturamento;
    private Double totalFaturamentoCarro;
    private Double totalFaturamentoMoto;
    private Double totalFaturamentoUtilitario;


    public void darEntrada(VehicleEntity vehicleEntity){}
    public void darSaida(VehicleEntity vehicleEntity){}
    public void procurar(String placa){}








}
