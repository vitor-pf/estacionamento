package com.nttdata.estacionamento.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parking {
    @Id
    private Long id;
    private Double valorHora;
    private Double totalFaturamento;
    private Double totalFaturamentoCarro;
    private Double totalFaturamentoMoto;
    private Double totalFaturamentoUtilitario;


    public void darEntrada(Vehicle vehicle){}
    public void darSaida(Vehicle vehicle){}
    public void procurar(String placa){}








}
