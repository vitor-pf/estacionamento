package com.nttdata.estacionamento.controllers;
import com.nttdata.estacionamento.entities.UtilityEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
@RestController
@RequestMapping(value = "utilitarios")
public class UtilityController {
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable @Valid Long id){
        return ResponseEntity.status(HttpStatus.OK).body("id ok");
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid UtilityEntity entity){
        return ResponseEntity.status(HttpStatus.CREATED).body("save");
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable @Valid Long id, @RequestBody @Valid UtilityEntity entity){
        return ResponseEntity.status(HttpStatus.OK).body("update");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable @Valid Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
