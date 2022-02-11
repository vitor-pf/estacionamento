package com.nttdata.estacionamento.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class ParkingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1L, message = "O valor deve ser > R$ 1,00!")
    private Double valorHora;

    private Double totalFaturamento;
    private Double totalFaturamentoCarro;
    private Double totalFaturamentoMoto;
    private Double totalFaturamentoUtilitario;


    @OneToMany(mappedBy = "parking")
    private List<VehicleEntity> vehicles;

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }
}
