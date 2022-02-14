package com.nttdata.estacionamento.exceptions;

import java.io.Serializable;

public class NotFoundException  extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public NotFoundException(String msg){
        super(msg);
    }
}
