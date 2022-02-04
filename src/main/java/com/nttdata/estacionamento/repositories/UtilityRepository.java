package com.nttdata.estacionamento.repositories;

import com.nttdata.estacionamento.entities.UtilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilityRepository extends JpaRepository<UtilityEntity, String> {
}
