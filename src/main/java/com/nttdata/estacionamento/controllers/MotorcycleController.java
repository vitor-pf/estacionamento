package com.nttdata.estacionamento.controllers;
import com.nttdata.estacionamento.entities.MotorcycleEntity;
import com.nttdata.estacionamento.repositories.CarRepository;
import com.nttdata.estacionamento.repositories.MotorcycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
@RestController
@RequestMapping(value = "/motos")
public class MotorcycleController {
    @Autowired
    MotorcycleRepository repository;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }
    @GetMapping("/{placa}")
    public ResponseEntity<?> findById(@PathVariable @Valid String placa){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findById(placa));
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid MotorcycleEntity entity){
        return ResponseEntity.status(HttpStatus.CREATED).body("save");
    }
    @PutMapping("/{placa}")
    public ResponseEntity<?> update(@PathVariable @Valid Long placa, @RequestBody @Valid MotorcycleEntity entity){
        return ResponseEntity.status(HttpStatus.OK).body("update");
    }
    @DeleteMapping("/{placa}")
    public ResponseEntity<?> delete(@PathVariable @Valid String placa){
        repository.deleteById(placa);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
