package com.nttdata.estacionamento.services;

import com.nttdata.estacionamento.entities.CarEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface CarInterface {

    List<CarEntity> findAll();

    CarEntity findById(@PathVariable @Valid String placa);

    CarEntity save(@RequestBody @Valid CarEntity entity);

    CarEntity update(@PathVariable @Valid String placa, @RequestBody @Valid CarEntity entity);

    void delete(@PathVariable @Valid String placa);

}
