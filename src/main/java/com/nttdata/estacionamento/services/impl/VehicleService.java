package com.nttdata.estacionamento.services.impl;
import com.nttdata.estacionamento.entities.VehicleEntity;
import com.nttdata.estacionamento.repositories.VehicleRepository;
import com.nttdata.estacionamento.services.VehicleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VehicleService implements VehicleInterface {
    @Autowired
    VehicleRepository repository;

    @Override
    public List<VehicleEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public VehicleEntity findById(String placa) {
        return repository.findById(placa).get();
    }

    @Override
    public VehicleEntity save(VehicleEntity entity) {

        return repository.save(entity);
    }

    @Override
    public VehicleEntity update(String placa, VehicleEntity entity) {
        findById(placa);
        return repository.save(entity);
    }

    @Override
    public void delete(String placa) {
        findById(placa);
        repository.deleteById(placa);
    }

    public void calcularValor(VehicleEntity vehicle, Double valorHora ) {


    }
}
