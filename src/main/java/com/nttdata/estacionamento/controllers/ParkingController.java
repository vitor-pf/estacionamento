package com.nttdata.estacionamento.controllers;
import com.nttdata.estacionamento.entities.ParkingEntity;
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
    public ResponseEntity<ParkingEntity> save(@RequestBody @Valid ParkingEntity entity){
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingInterface.save(entity));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ParkingEntity> update(@PathVariable @Valid Long id, @RequestBody @Valid ParkingEntity entity){
        return ResponseEntity.status(HttpStatus.OK).body(parkingInterface.update(id,entity));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable @Valid Long id){
        parkingInterface.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
