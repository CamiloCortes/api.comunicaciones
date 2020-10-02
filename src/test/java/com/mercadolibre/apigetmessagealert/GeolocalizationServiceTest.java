package com.mercadolibre.apigetmessagealert;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mercadolibre.apigetmessagealert.services.IGeolocalizationService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GeolocalizationServiceTest {

	@Autowired
	private IGeolocalizationService geolocalizationService;

	/**
	 * valida la funcionalidad que triangula las pociciones o coordenadas
	 * @throws Exception
	 */
	@Test
	void validateGeolocalization() throws Exception {

		double[][] positions = new double[][] { { -500, -200 }, { 100, -100 }, { 500, 100 } };
		double[] distances = new double[] { 100.0, 115.5, 142.7 };
		assertThat((geolocalizationService.getGeolocalization(positions, distances).getX())).isEqualTo(-58.32);
		assertThat((geolocalizationService.getGeolocalization(positions, distances).getY())).isEqualTo(-69.55);

	}

}
