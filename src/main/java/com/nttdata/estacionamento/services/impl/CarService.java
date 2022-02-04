package com.nttdata.estacionamento.services.impl;
import com.nttdata.estacionamento.entities.CarEntity;
import com.nttdata.estacionamento.repositories.CarRepository;
import com.nttdata.estacionamento.services.CarInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarService implements CarInterface {
    @Autowired
    CarRepository repository;

    @Override
    public List<CarEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public CarEntity findById(String placa) {
        return repository.findById(placa).get();
    }

    @Override
    public CarEntity save(CarEntity entity) {
        return repository.save(entity);
    }

    @Override
    public CarEntity update(String placa, CarEntity entity) {
        findById(placa);
        return repository.save(entity);
    }

    @Override
    public void delete(String placa) {
        findById(placa);
        repository.deleteById(placa);
    }
}
