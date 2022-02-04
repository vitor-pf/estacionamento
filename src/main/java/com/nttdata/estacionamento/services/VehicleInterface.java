package com.nttdata.estacionamento.services;

import com.nttdata.estacionamento.entities.VehicleEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface VehicleInterface {

    List<VehicleEntity> findAll();

    VehicleEntity findById(@PathVariable @Valid String placa);

    VehicleEntity save(@RequestBody @Valid VehicleEntity entity);

    VehicleEntity update(@PathVariable @Valid String placa, @RequestBody @Valid VehicleEntity entity);

    void delete(@PathVariable @Valid String placa);








}
