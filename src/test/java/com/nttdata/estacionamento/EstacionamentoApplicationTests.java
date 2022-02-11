package com.nttdata.estacionamento;

import com.nttdata.estacionamento.dtos.ParkingEntityDTO;
import com.nttdata.estacionamento.entities.ParkingEntity;
import com.nttdata.estacionamento.repositories.ParkingRepository;
import com.nttdata.estacionamento.services.impl.ParkingService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class EstacionamentoApplicationTests {
	/*
	@InjectMocks
	ParkingService parkingService;
	@Mock
	ParkingRepository parkingRepository;

	@Test
	void createParking() throws Exception {


		ParkingEntity entity = new ParkingEntity();
		entity.setId(1L);
		entity.setValorHora(100.00);
		ParkingEntityDTO dto = new ParkingEntityDTO();
		dto.setValorHora(100.00);


		Mockito.when(parkingRepository.save(entity))
				.thenReturn(entity);
		ParkingEntity result = parkingService.save(dto);


		assertEquals(100.00, result.getValorHora());


	}


	 */
}
