package com.nttdata.estacionamento.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "tb_utility")
public class UtilityEntity extends VehicleEntity implements Serializable {
    private static final long serialVersionUID = 1L;
}
