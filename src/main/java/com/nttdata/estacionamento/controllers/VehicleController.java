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
import java.util.List;

@RestController
@RequestMapping(value = "/veiculos")
public class VehicleController {
    @Autowired
    VehicleRepository repository;

    @GetMapping
    public ResponseEntity<List<VehicleEntity>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

}
