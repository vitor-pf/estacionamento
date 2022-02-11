package com.nttdata.estacionamento.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nttdata.estacionamento.enums.FatorEstaciomento;
import com.nttdata.estacionamento.enums.Marca;
import lombok.*;

import javax.persistence.*;
import javax.validation.GroupSequence;
import javax.validation.constraints.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class VehicleEntity  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    //@Size(min = 5, max = 5, message = "Atenção aos caracteres!")
    //@NotBlank(message = "A hora deve conter 5 caracteres!")
    private String horaSaida;

    private Double totalEstacionamento;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "parkingId", referencedColumnName = "id")
    private ParkingEntity parking;
}
