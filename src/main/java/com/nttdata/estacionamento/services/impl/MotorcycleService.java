package com.nttdata.estacionamento.services.impl;
import com.nttdata.estacionamento.entities.CarEntity;
import com.nttdata.estacionamento.entities.MotorcycleEntity;
import com.nttdata.estacionamento.entities.ParkingEntity;
import com.nttdata.estacionamento.entities.VehicleEntity;
import com.nttdata.estacionamento.repositories.MotorcycleRepository;
import com.nttdata.estacionamento.services.MotorcycleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
    public MotorcycleEntity findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    public VehicleEntity save(ParkingEntity parking, VehicleEntity vehicle) {
        MotorcycleEntity obj = new MotorcycleEntity();

        obj.setPlaca(vehicle.getPlaca());
        obj.setMarca(vehicle.getMarca());
        obj.setModelo(vehicle.getModelo());
        obj.setFatorEstacionamento(vehicle.getFatorEstacionamento());
        obj.setParking(parking);

        obj.setHoraEntrada(vehicle.getHoraEntrada());
        //String entrada = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        //obj.setHoraEntrada(entrada);
        return repository.save(obj);
    }

    public VehicleEntity update(Long id, VehicleEntity entity) {
        MotorcycleEntity obj = repository.findById(id).get();

        obj.setHoraSaida(entity.getHoraSaida());
        obj.setTotalEstacionamento(entity.getTotalEstacionamento());
        return repository.save(obj);
    }
}
