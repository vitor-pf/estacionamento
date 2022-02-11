package com.nttdata.estacionamento.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nttdata.estacionamento.enums.FatorEstaciomento;
import com.nttdata.estacionamento.enums.Marca;
import lombok.*;

import javax.persistence.*;
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
    private String placa;
    private Marca marca;
    private String modelo;
    private FatorEstaciomento fatorEstacionamento;
    private String horaEntrada;
    private String horaSaida;
    private Double totalEstacionamento;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "parkingId", referencedColumnName = "id")
    private ParkingEntity parking;
}
