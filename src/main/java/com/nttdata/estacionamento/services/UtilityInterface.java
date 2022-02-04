package com.nttdata.estacionamento.services;

import com.nttdata.estacionamento.entities.UtilityEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface UtilityInterface {

    List<UtilityEntity> findAll();

    UtilityEntity findById(@PathVariable @Valid String placa);

    UtilityEntity save(@RequestBody @Valid UtilityEntity entity);

    UtilityEntity update(@PathVariable @Valid String placa, @RequestBody @Valid UtilityEntity entity);

    void delete(@PathVariable @Valid String placa);








}
