package com.nttdata.estacionamento.enums;

public enum Marca {
    FIAT(1), FORD(2), HONDA(3);
    private Integer type;

    Marca(int i) {
        this.type = i;
    }

    public Integer getType() {
        return type;
    }

}
