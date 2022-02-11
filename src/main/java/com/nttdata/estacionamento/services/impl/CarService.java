package com.nttdata.estacionamento.services.impl;
import com.nttdata.estacionamento.entities.CarEntity;
import com.nttdata.estacionamento.entities.ParkingEntity;
import com.nttdata.estacionamento.entities.VehicleEntity;
import com.nttdata.estacionamento.repositories.CarRepository;
import com.nttdata.estacionamento.services.CarInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CarService implements CarInterface{
    @Autowired
    CarRepository repository;

    @Override
    public List<CarEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public CarEntity findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }




    public VehicleEntity save(ParkingEntity parking, VehicleEntity vehicle) {
        CarEntity obj = new CarEntity();

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

    public VehicleEntity update(Long id_vehicle, VehicleEntity vehicle) {
        CarEntity obj = repository.findById(id_vehicle).get();
        
        obj.setHoraSaida(vehicle.getHoraSaida());
        obj.setTotalEstacionamento(vehicle.getTotalEstacionamento());
        return repository.save(obj);
    }
}
