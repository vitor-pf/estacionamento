package com.nttdata.estacionamento.services;

import com.nttdata.estacionamento.entities.UtilityEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface UtilityInterface {

    List<UtilityEntity> findAll();

    UtilityEntity findById(@PathVariable @Valid Long id);

    void delete(@PathVariable @Valid Long id);

}
