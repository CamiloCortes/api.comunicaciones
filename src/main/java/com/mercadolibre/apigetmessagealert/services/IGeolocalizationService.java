package com.mercadolibre.apigetmessagealert.services;

import com.mercadolibre.apigetmessagealert.entity.Geolocalization;

public interface IGeolocalizationService {
	
	public Geolocalization getGeolocalization(double[][] positions, double[] distances);
}
