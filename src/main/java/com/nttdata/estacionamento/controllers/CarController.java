package com.nttdata.estacionamento.controllers;
import com.nttdata.estacionamento.entities.CarEntity;
import com.nttdata.estacionamento.entities.ParkingEntity;
import com.nttdata.estacionamento.repositories.CarRepository;
import com.nttdata.estacionamento.services.CarInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/carros")
public class CarController {
    @Autowired
    CarInterface car;

    @GetMapping
    public ResponseEntity<List<CarEntity>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(car.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarEntity> findById(@PathVariable @Valid Long id){
        return ResponseEntity.status(HttpStatus.OK).body(car.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable @Valid Long id){
        car.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
