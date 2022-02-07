package com.nttdata.estacionamento.controllers;
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
    UtilityInterface utilityInterface;

    @GetMapping
    public ResponseEntity<List<UtilityEntity>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(utilityInterface.findAll());
    }
    @GetMapping("/{placa}")
    public ResponseEntity<UtilityEntity> findById(@PathVariable @Valid String placa){
        return ResponseEntity.status(HttpStatus.OK).body(utilityInterface.findById(placa));
    }
    @PostMapping
    public ResponseEntity<UtilityEntity> save(@RequestBody @Valid UtilityEntity entity){
        return ResponseEntity.status(HttpStatus.CREATED).body(utilityInterface.save(entity));
    }
    @PutMapping("/{placa}")
    public ResponseEntity<UtilityEntity> update(@PathVariable @Valid String placa, @RequestBody @Valid UtilityEntity entity){
        return ResponseEntity.status(HttpStatus.OK).body(utilityInterface.update(placa, entity));
    }
    @DeleteMapping("/{placa}")
    public ResponseEntity delete(@PathVariable @Valid String placa){
        utilityInterface.delete(placa);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
