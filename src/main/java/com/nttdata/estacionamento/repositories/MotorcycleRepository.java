package com.nttdata.estacionamento.repositories;

import com.nttdata.estacionamento.entities.MotorcycleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorcycleRepository extends JpaRepository<MotorcycleEntity, String> {
}
