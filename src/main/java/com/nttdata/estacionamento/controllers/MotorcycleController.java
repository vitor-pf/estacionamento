package com.nttdata.estacionamento.controllers;
import com.nttdata.estacionamento.entities.CarEntity;
import com.nttdata.estacionamento.entities.MotorcycleEntity;
import com.nttdata.estacionamento.repositories.CarRepository;
import com.nttdata.estacionamento.repositories.MotorcycleRepository;
import com.nttdata.estacionamento.services.CarInterface;
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
    MotorcycleInterface motorcycle;

    @GetMapping
    public ResponseEntity<List<MotorcycleEntity>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(motorcycle.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MotorcycleEntity> findById(@PathVariable @Valid Long id){
        return ResponseEntity.status(HttpStatus.OK).body(motorcycle.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable @Valid Long id){
        motorcycle.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
