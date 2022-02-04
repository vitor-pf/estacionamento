package com.nttdata.estacionamento.repositories;

import com.nttdata.estacionamento.entities.VehicleEntity;
import com.nttdata.estacionamento.enums.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, String> {

    List<?> findByMarca(Marca marca);
}
