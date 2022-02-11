package com.nttdata.estacionamento.controllers;
import com.nttdata.estacionamento.entities.MotorcycleEntity;
import com.nttdata.estacionamento.entities.UtilityEntity;
import com.nttdata.estacionamento.repositories.CarRepository;
import com.nttdata.estacionamento.repositories.UtilityRepository;
import com.nttdata.estacionamento.services.UtilityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/utilitarios")
public class UtilityController {
    @Autowired
    UtilityInterface utility;

    @GetMapping
    public ResponseEntity<List<UtilityEntity>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(utility.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UtilityEntity> findById(@PathVariable @Valid Long id){
        return ResponseEntity.status(HttpStatus.OK).body(utility.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable @Valid Long id){
        utility.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
