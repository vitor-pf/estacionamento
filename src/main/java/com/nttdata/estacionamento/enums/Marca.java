package com.nttdata.estacionamento.enums;

public enum Marca {
    MOTO(1), CARRO(2), UTILITARIO(3);
    private Integer type;

    Marca(int i) {
        this.type = i;
    }

    public Integer getType() {
        return type;
    }

}
