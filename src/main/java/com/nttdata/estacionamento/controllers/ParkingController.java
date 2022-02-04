package com.nttdata.estacionamento.controllers;
import com.nttdata.estacionamento.entities.ParkingEntity;
import com.nttdata.estacionamento.repositories.CarRepository;
import com.nttdata.estacionamento.repositories.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
@RestController
@RequestMapping(value = "/estacionamentos")
public class ParkingController {
    @Autowired
    ParkingRepository repository;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable @Valid Long id){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id));
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid ParkingEntity entity){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(entity));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable @Valid Long id, @RequestBody @Valid ParkingEntity entity){
        return ResponseEntity.status(HttpStatus.OK).body("update");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable @Valid Long id){
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
