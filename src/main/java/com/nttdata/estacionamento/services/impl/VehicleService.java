package com.nttdata.estacionamento.services.impl;
import com.nttdata.estacionamento.dtos.VehicleEntityExitDTO;
import com.nttdata.estacionamento.entities.VehicleEntity;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Locale;

@Service
public class VehicleService {

    public Double calcularValor(VehicleEntityExitDTO vehicle, Double valorHora ) {
        LocalTime entrada = LocalTime.parse(vehicle.getHoraEntrada());
        LocalTime saida = LocalTime.parse(vehicle.getHoraSaida());

        double res = Math.ceil( Double.valueOf(Duration.between(entrada,saida).toMinutes())/60 );

        return res*vehicle.getFatorEstacionamento().getType()*valorHora;
    }

}
