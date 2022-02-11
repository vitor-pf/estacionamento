package com.nttdata.estacionamento.enums;

public enum FatorEstaciomento {
    MOTO(0.85), CARRO(1.0), UTILITARIO(1.15);
    private Double type;

    private FatorEstaciomento(Double i) {
        this.type = i;
    }

    public Double getType() {
        return type;
    }

}
