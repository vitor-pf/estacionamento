package com.nttdata.estacionamento.services.impl;
import com.nttdata.estacionamento.entities.UtilityEntity;
import com.nttdata.estacionamento.repositories.UtilityRepository;
import com.nttdata.estacionamento.services.UtilityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UtilityService implements UtilityInterface {
    @Autowired
    UtilityRepository repository;

    @Override
    public List<UtilityEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public UtilityEntity findById(String placa) {
        return null;
    }

    @Override
    public UtilityEntity save(UtilityEntity entity) {
        return repository.save(entity);
    }

    @Override
    public UtilityEntity update(String placa, UtilityEntity entity) {
        findById(placa);
        return repository.save(entity);
    }

    @Override
    public void delete(String placa) {

    }
}
