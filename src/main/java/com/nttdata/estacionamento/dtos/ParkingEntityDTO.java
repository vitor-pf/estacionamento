package com.nttdata.estacionamento.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Setter
@Getter
@NoArgsConstructor
public class ParkingEntityDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    @Min(value = 1L, message = "O valor deve ser > R$ 1,00!")
    private Double valorHora;

}
