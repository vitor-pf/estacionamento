package com.nttdata.estacionamento.dtos;

import com.nttdata.estacionamento.enums.FatorEstaciomento;
import com.nttdata.estacionamento.enums.Marca;
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
public class VehicleEntityDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Size(min = 8, max = 8, message = "Falta caracteres!")
    @NotBlank(message = "A placa e o (-) contém 8 caracteres!")
    private String placa;

    private Marca marca;

    @Size(min = 2, max = 50, message = "Deve conter 50 caracteres!")
    @NotBlank(message = "O modelo é obrigatório!")
    private String modelo;

    private FatorEstaciomento fatorEstacionamento;

    @Size(min = 5, max = 5, message = "Atenção aos caracteres!")
    @NotBlank(message = "A hora deve conter 5 caracteres!")
    private String horaEntrada;

}
