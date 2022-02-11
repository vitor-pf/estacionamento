package com.nttdata.estacionamento.services.impl;
import com.nttdata.estacionamento.entities.*;
import com.nttdata.estacionamento.enums.FatorEstaciomento;
import com.nttdata.estacionamento.repositories.ParkingRepository;
import com.nttdata.estacionamento.services.ParkingInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class ParkingService implements ParkingInterface {
    @Autowired
    ParkingRepository repository;
    @Autowired
    VehicleService vehicleService;
    @Autowired
    CarService car;
    @Autowired
    MotorcycleService motorcycle;
    @Autowired
    UtilityService utility;


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
        entity.setId(id);
        return repository.save(entity);
    }
    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }





    public VehicleEntity darEntrada(Long id, VehicleEntity vehicleEntity){
        ParkingEntity parking = findById(id);
        for (VehicleEntity obj : parking.getVehicles()){
            if(obj.getPlaca().equals(vehicleEntity.getPlaca()) && obj.getHoraSaida() == null)
                throw new IllegalArgumentException("Carro consta no sistema");
        }

        if(vehicleEntity.getFatorEstacionamento().equals(FatorEstaciomento.CARRO)){
            return car.save(parking, vehicleEntity);
        }
        else if(vehicleEntity.getFatorEstacionamento().equals(FatorEstaciomento.MOTO)){
            return motorcycle.save(parking, vehicleEntity);
        }
        else if(vehicleEntity.getFatorEstacionamento().equals(FatorEstaciomento.UTILITARIO)){
            return utility.save(parking, vehicleEntity);
        }
        return null;
    }
    public VehicleEntity darSaida(Long id, Long id_vehicle,VehicleEntity vehicle){
        ParkingEntity parking = findById(id);
        for (VehicleEntity obj : parking.getVehicles()){
            if(obj.getId().equals(id_vehicle) && obj.getHoraSaida() != null)
                throw new IllegalArgumentException("Carro com saida");
        }
        String saida = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        //vehicle.setHoraSaida(saida);
        vehicle.setTotalEstacionamento(
                vehicleService.calcularValor(vehicle, parking.getValorHora())
        );
        if(vehicle.getFatorEstacionamento().equals(FatorEstaciomento.CARRO)){
            parking.setTotalFaturamentoCarro(
                    parking.getTotalFaturamentoCarro()+vehicle.getTotalEstacionamento()
            );
            vehicle = car.update(id_vehicle, vehicle);
        }
        else if(vehicle.getFatorEstacionamento().equals(FatorEstaciomento.MOTO)){
            parking.setTotalFaturamentoMoto(
                    parking.getTotalFaturamentoMoto()+vehicle.getTotalEstacionamento()
            );
            vehicle = motorcycle.update(id_vehicle, vehicle);
        }
        else if(vehicle.getFatorEstacionamento().equals(FatorEstaciomento.UTILITARIO)){
            parking.setTotalFaturamentoUtilitario(
                    parking.getTotalFaturamentoUtilitario()+vehicle.getTotalEstacionamento()
            );
            vehicle = utility.update(id_vehicle, vehicle);
        }
        parking.setTotalFaturamento(
                parking.getTotalFaturamentoMoto()+
                        parking.getTotalFaturamentoCarro()+
                        parking.getTotalFaturamentoUtilitario()
        );
        repository.save(parking);
        return vehicle;
    }
    public VehicleEntity procurar(Long id, String placa){
        ParkingEntity parking = repository.findById(id).get();
        for (VehicleEntity vehicle : parking.getVehicles()) {
            if (vehicle.getPlaca().equals(placa) && vehicle.getHoraSaida() == null)
                return vehicle;
        }
        throw new IllegalArgumentException("Carro não encontado");
    }
}
