package com.nttdata.estacionamento.services;

import com.nttdata.estacionamento.entities.MotorcycleEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface MotorcycleInterface {

    List<MotorcycleEntity> findAll();

    MotorcycleEntity findById(@PathVariable @Valid String placa);

    MotorcycleEntity save(@RequestBody @Valid MotorcycleEntity entity);

    MotorcycleEntity update(@PathVariable @Valid String placa, @RequestBody @Valid MotorcycleEntity entity);

    void delete(@PathVariable @Valid String placa);









}
