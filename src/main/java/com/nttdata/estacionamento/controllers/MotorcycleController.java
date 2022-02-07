package com.nttdata.estacionamento.controllers;
import com.nttdata.estacionamento.entities.MotorcycleEntity;
import com.nttdata.estacionamento.repositories.CarRepository;
import com.nttdata.estacionamento.repositories.MotorcycleRepository;
import com.nttdata.estacionamento.services.MotorcycleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/motos")
public class MotorcycleController {
    @Autowired
    MotorcycleInterface motorcycleInterface;

    @GetMapping
    public ResponseEntity<List<MotorcycleEntity>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(motorcycleInterface.findAll());
    }
    @GetMapping("/{placa}")
    public ResponseEntity<MotorcycleEntity> findById(@PathVariable @Valid String placa){
        return ResponseEntity.status(HttpStatus.OK).body(motorcycleInterface.findById(placa));
    }
    @PostMapping
    public ResponseEntity<MotorcycleEntity> save(@RequestBody @Valid MotorcycleEntity entity){
        return ResponseEntity.status(HttpStatus.CREATED).body(motorcycleInterface.save(entity));
    }
    @PutMapping("/{placa}")
    public ResponseEntity<MotorcycleEntity> update(@PathVariable @Valid String placa, @RequestBody @Valid MotorcycleEntity entity){
        return ResponseEntity.status(HttpStatus.OK).body(motorcycleInterface.update(placa,entity));
    }
    @DeleteMapping("/{placa}")
    public ResponseEntity delete(@PathVariable @Valid String placa){
        motorcycleInterface.delete(placa);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
