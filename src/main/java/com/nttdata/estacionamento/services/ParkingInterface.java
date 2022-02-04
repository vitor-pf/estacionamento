package com.nttdata.estacionamento.services;

import com.nttdata.estacionamento.entities.ParkingEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface ParkingInterface {

    List<ParkingEntity> findAll();

    ParkingEntity findById(@PathVariable @Valid Long id);

    ParkingEntity save(@RequestBody @Valid ParkingEntity entity);

    ParkingEntity update(@PathVariable @Valid Long id, @RequestBody @Valid ParkingEntity entity);

    void delete(@PathVariable @Valid Long id);








}
