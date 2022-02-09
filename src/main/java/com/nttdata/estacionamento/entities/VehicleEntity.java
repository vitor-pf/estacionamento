package com.nttdata.estacionamento.entities;

import com.nttdata.estacionamento.enums.Marca;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
//@MappedSuperclass
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(unique = true)
    private String placa;
    private Marca marca;
    private String modelo;
    private Double fatorEstacionamento;
    private String horaEntrada;
    private String horaSaida;
    private Double totalEstacionamento;

    @ManyToOne
    @JoinColumn(name = "parkingId", referencedColumnName = "id")
    private ParkingEntity parking;
}
