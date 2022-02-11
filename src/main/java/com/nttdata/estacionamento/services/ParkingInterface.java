package com.nttdata.estacionamento.services;

import com.nttdata.estacionamento.dtos.ParkingEntityDTO;
import com.nttdata.estacionamento.dtos.VehicleEntityDTO;
import com.nttdata.estacionamento.dtos.VehicleEntityExitDTO;
import com.nttdata.estacionamento.entities.ParkingEntity;
import com.nttdata.estacionamento.entities.VehicleEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface ParkingInterface {

    List<ParkingEntity> findAll();

    ParkingEntity findById(Long id);

    ParkingEntity save(ParkingEntityDTO entity);

    ParkingEntity update(Long id, ParkingEntityDTO entity);

    void delete(Long id);

    VehicleEntity darEntrada(Long id, VehicleEntityDTO vehicleEntity);

    VehicleEntity darSaida(Long id, Long id_vehicle, VehicleEntityExitDTO vehicleEntity);

    VehicleEntity procurar(Long id, String placa);




}
