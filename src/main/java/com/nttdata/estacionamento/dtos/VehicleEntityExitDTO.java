package com.nttdata.estacionamento.dtos;

import com.nttdata.estacionamento.enums.FatorEstaciomento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleEntityExitDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private FatorEstaciomento fatorEstacionamento;

    @Size(min = 5, max = 5, message = "Atenção aos caracteres!")
    @NotBlank(message = "A hora deve conter 5 caracteres!")
    private String horaEntrada;
    @Size(min = 5, max = 5, message = "Atenção aos caracteres!")
    @NotBlank(message = "A hora deve conter 5 caracteres!")
    private String horaSaida;

    private Double totalEstacionamento;

}
