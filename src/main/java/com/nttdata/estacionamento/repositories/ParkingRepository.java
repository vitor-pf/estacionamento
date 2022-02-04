package com.nttdata.estacionamento.repositories;

import com.nttdata.estacionamento.entities.ParkingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<ParkingEntity, Long> {
}
