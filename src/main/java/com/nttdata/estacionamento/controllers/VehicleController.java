package com.nttdata.estacionamento.controllers;
import com.nttdata.estacionamento.entities.VehicleEntity;
import com.nttdata.estacionamento.enums.Marca;
import com.nttdata.estacionamento.repositories.CarRepository;
import com.nttdata.estacionamento.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping(value = "/veiculos")
public class VehicleController {
    @Autowired
    VehicleRepository repository;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }
    @GetMapping("/{marca}")
    public ResponseEntity<?> findById(@PathVariable @Valid Marca marca){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findByMarca(marca));
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid VehicleEntity entity){
        return ResponseEntity.status(HttpStatus.CREATED).body("save");
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable @Valid Long id, @RequestBody @Valid VehicleEntity entity){
        return ResponseEntity.status(HttpStatus.OK).body("update");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable @Valid Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
