package com.nttdata.estacionamento.services.impl;
import com.nttdata.estacionamento.entities.MotorcycleEntity;
import com.nttdata.estacionamento.repositories.MotorcycleRepository;
import com.nttdata.estacionamento.services.MotorcycleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MotorcycleService implements MotorcycleInterface {
    @Autowired
    MotorcycleRepository repository;

    @Override
    public List<MotorcycleEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public MotorcycleEntity findById(String placa) {
        return repository.findById(placa).get();
    }

    @Override
    public MotorcycleEntity save(MotorcycleEntity entity) {
        return repository.save(entity);
    }

    @Override
    public MotorcycleEntity update(String placa, MotorcycleEntity entity) {
        findById(placa);
        return repository.save(entity);
    }

    @Override
    public void delete(String placa) {
        findById(placa);
        repository.deleteById(placa);
    }
}
