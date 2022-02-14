package com.nttdata.estacionamento.services.impl;
import com.nttdata.estacionamento.dtos.VehicleEntityDTO;
import com.nttdata.estacionamento.dtos.VehicleEntityExitDTO;
import com.nttdata.estacionamento.entities.CarEntity;
import com.nttdata.estacionamento.entities.MotorcycleEntity;
import com.nttdata.estacionamento.entities.ParkingEntity;
import com.nttdata.estacionamento.entities.VehicleEntity;
import com.nttdata.estacionamento.exceptions.NotFoundException;
import com.nttdata.estacionamento.repositories.MotorcycleRepository;
import com.nttdata.estacionamento.services.MotorcycleInterface;
import org.modelmapper.ModelMapper;
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

    @Autowired
    ModelMapper modelMapper;
    private MotorcycleEntity toMotorcycleEntity(VehicleEntityDTO dto) {
        return modelMapper.map(dto, MotorcycleEntity.class);
    }

    @Override
    public List<MotorcycleEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public MotorcycleEntity findById(Long id) {
        return repository.findById(id).orElseThrow(()-> new NotFoundException("Id não encontrado!"));
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    public VehicleEntity save(ParkingEntity parking, VehicleEntityDTO vehicle) {
        MotorcycleEntity obj = toMotorcycleEntity(vehicle);
        obj.setParking(parking);
        //String entrada = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        //obj.setHoraEntrada(entrada);

        return repository.save(obj);
    }

    public VehicleEntity update(Long id, VehicleEntityExitDTO entity) {
        MotorcycleEntity obj = findById(id);

        obj.setHoraSaida(entity.getHoraSaida());
        obj.setTotalEstacionamento(entity.getTotalEstacionamento());
        return repository.save(obj);
    }
}
