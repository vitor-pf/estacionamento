package com.nttdata.estacionamento.exceptions;

import java.io.Serializable;

public class ProcessException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ProcessException(String msg){
        super(msg);
    }
}
