package com.nttdata.estacionamento.enums;

public enum Marca {
    FIAT(1), FORD(2), HONDA(3);
    private int type;

    private Marca(int i) {
        this.type = i;
    }

    public int getType() {
        return type;
    }

}
