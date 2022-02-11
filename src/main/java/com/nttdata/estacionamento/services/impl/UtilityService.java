package com.nttdata.estacionamento.services.impl;
import com.nttdata.estacionamento.dtos.VehicleEntityDTO;
import com.nttdata.estacionamento.dtos.VehicleEntityExitDTO;
import com.nttdata.estacionamento.entities.*;
import com.nttdata.estacionamento.repositories.UtilityRepository;
import com.nttdata.estacionamento.services.UtilityInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class UtilityService implements UtilityInterface{
    @Autowired
    UtilityRepository repository;

    @Autowired
    ModelMapper modelMapper;
    private UtilityEntity toMotorcycleEntity(VehicleEntityDTO dto) {
        return modelMapper.map(dto, UtilityEntity.class);
    }

    @Override
    public List<UtilityEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public UtilityEntity findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    public VehicleEntity save(ParkingEntity parking, VehicleEntityDTO vehicle) {
        UtilityEntity obj = toMotorcycleEntity(vehicle);
        obj.setParking(parking);
        //String entrada = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        //obj.setHoraEntrada(entrada);

        return repository.save(obj);
    }

    public VehicleEntity update(Long id, VehicleEntityExitDTO entity) {
        UtilityEntity obj = repository.findById(id).get();

        obj.setHoraSaida(entity.getHoraSaida());
        obj.setTotalEstacionamento(entity.getTotalEstacionamento());
        return repository.save(obj);
    }
}
