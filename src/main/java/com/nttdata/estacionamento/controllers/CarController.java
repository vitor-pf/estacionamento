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
    CarInterface carInterface;

    @GetMapping
    public ResponseEntity<List<CarEntity>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(carInterface.findAll());
    }
    @GetMapping("/{placa}")
    public ResponseEntity<CarEntity> findById(@PathVariable @Valid String placa){
        return ResponseEntity.status(HttpStatus.OK).body(carInterface.findById(placa));
    }
    @PostMapping
    public ResponseEntity<CarEntity> save(@RequestBody @Valid CarEntity entity){
        return ResponseEntity.status(HttpStatus.CREATED).body(carInterface.save(entity));
    }
    @PutMapping("/{placa}")
    public ResponseEntity<CarEntity> update(@PathVariable @Valid String placa, @RequestBody @Valid CarEntity entity){
        return ResponseEntity.status(HttpStatus.OK).body(carInterface.update(placa, entity));
    }
    @DeleteMapping("/{placa}")
    public ResponseEntity delete(@PathVariable @Valid String placa){
        carInterface.delete(placa);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
