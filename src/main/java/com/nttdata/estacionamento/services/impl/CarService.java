package com.nttdata.estacionamento.services.impl;
import com.nttdata.estacionamento.dtos.VehicleEntityDTO;
import com.nttdata.estacionamento.dtos.VehicleEntityExitDTO;
import com.nttdata.estacionamento.entities.CarEntity;
import com.nttdata.estacionamento.entities.ParkingEntity;
import com.nttdata.estacionamento.entities.VehicleEntity;
import com.nttdata.estacionamento.exceptions.NotFoundException;
import com.nttdata.estacionamento.repositories.CarRepository;
import com.nttdata.estacionamento.services.CarInterface;
import org.modelmapper.ModelMapper;
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

    @Autowired
    ModelMapper modelMapper;
    private CarEntity toVehicleEntity(VehicleEntityDTO dto) {
        return modelMapper.map(dto, CarEntity.class);
    }


    @Override
    public List<CarEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public CarEntity findById(Long id) {
        return repository.findById(id).orElseThrow(()-> new NotFoundException("Id não encontrado!"));
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    public VehicleEntity save(ParkingEntity parking, VehicleEntityDTO vehicle) {
        CarEntity obj = toVehicleEntity(vehicle);
        obj.setParking(parking);
        //String entrada = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        //obj.setHoraEntrada(entrada);

        return repository.save(obj);
    }

    public VehicleEntity update(Long id, VehicleEntityExitDTO vehicle) {
        CarEntity obj = findById(id);
        
        obj.setHoraSaida(vehicle.getHoraSaida());
        obj.setTotalEstacionamento(vehicle.getTotalEstacionamento());
        return repository.save(obj);
    }
}
