package com.nttdata.estacionamento.controllers;
import com.nttdata.estacionamento.dtos.ParkingEntityDTO;
import com.nttdata.estacionamento.dtos.VehicleEntityDTO;
import com.nttdata.estacionamento.dtos.VehicleEntityExitDTO;
import com.nttdata.estacionamento.entities.ParkingEntity;
import com.nttdata.estacionamento.entities.VehicleEntity;
import com.nttdata.estacionamento.repositories.CarRepository;
import com.nttdata.estacionamento.repositories.ParkingRepository;
import com.nttdata.estacionamento.services.ParkingInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/estacionamentos")
public class ParkingController {
    @Autowired
    ParkingInterface parkingInterface;

    @GetMapping
    public ResponseEntity<List<ParkingEntity>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(parkingInterface.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ParkingEntity> findById(@PathVariable @Valid Long id){
        return ResponseEntity.status(HttpStatus.OK).body(parkingInterface.findById(id));
    }
    @PostMapping
    public ResponseEntity<ParkingEntity> save(@RequestBody @Valid ParkingEntityDTO entity){
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingInterface.save(entity));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ParkingEntity> update(@PathVariable @Valid Long id, @RequestBody @Valid ParkingEntityDTO entity){
        return ResponseEntity.status(HttpStatus.OK).body(parkingInterface.update(id,entity));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable @Valid Long id){
        parkingInterface.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



    @PostMapping("/darEntrada/{id}")
    public ResponseEntity<VehicleEntity> darEntrada(@PathVariable @Valid Long id, @RequestBody @Valid VehicleEntityDTO vehicleEntity){
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingInterface.darEntrada(id, vehicleEntity));
    }
    @PutMapping("/darSaida/{id}/{id_vehicle}")
    public ResponseEntity<VehicleEntity> darSaida(@PathVariable @Valid Long id, @PathVariable @Valid Long id_vehicle, @RequestBody @Valid VehicleEntityExitDTO vehicleEntity){
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingInterface.darSaida(id, id_vehicle, vehicleEntity));
    }
    @GetMapping("/procurar/{id}/{placa}")
    public ResponseEntity procurar(@PathVariable @Valid Long id, @PathVariable @Valid String placa){
        return ResponseEntity.status(HttpStatus.OK).body(parkingInterface.procurar(id, placa));
    }
}
