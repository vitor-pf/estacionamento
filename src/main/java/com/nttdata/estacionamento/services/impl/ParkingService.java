package com.nttdata.estacionamento.services.impl;
import com.nttdata.estacionamento.entities.ParkingEntity;
import com.nttdata.estacionamento.repositories.ParkingRepository;
import com.nttdata.estacionamento.services.ParkingInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParkingService implements ParkingInterface {
    @Autowired
    ParkingRepository repository;

    @Override
    public List<ParkingEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ParkingEntity findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public ParkingEntity save(ParkingEntity entity) {
        return repository.save(entity);
    }

    @Override
    public ParkingEntity update(Long id, ParkingEntity entity) {
        findById(id);
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
