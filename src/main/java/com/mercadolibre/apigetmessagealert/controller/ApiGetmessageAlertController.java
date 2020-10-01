package com.mercadolibre.apigetmessagealert.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.apigetmessagealert.entity.Satellites;
import com.mercadolibre.apigetmessagealert.services.IGeolocalizationService;
import com.mercadolibre.apigetmessagealert.services.IMessageService;

@RestController
@RequestMapping("/api")
public class ApiGetmessageAlertController {

	@Autowired
	private IGeolocalizationService geolocalizationService;
	@Autowired
	private IMessageService messageService;

	@PostMapping("/topsecret")
	public ResponseEntity<?> topsecret(@RequestBody Satellites satellites) {

		Map<String, Object> response = new HashMap<>();
		try {

			// get distances
			double[] distances = satellites.getSatellites().stream().map(t -> t.getDistance())
					.mapToDouble(Double::doubleValue).toArray();
			// get messages
			List<List<String>> Messages = satellites.getSatellites().stream().map(t -> t.getMessage())
					.collect(Collectors.toList());

			response.put("position", geolocalizationService
					.getGeolocalization(new double[][] { { -500, -200 }, { 100, -100 }, { 500, 100 } }, distances));
			response.put("message", messageService.getMessage(Messages));
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("RESPONSE CODE:", "404");

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		}
	}

	@GetMapping("/topsecret_split")
	public ResponseEntity<?> topsecretSplitGet(@RequestBody Satellites satellites) {
		Map<String, Object> response = new HashMap<>();
		try {

			// get distances
			double[] distances = satellites.getSatellites().stream().map(t -> t.getDistance())
					.mapToDouble(Double::doubleValue).toArray();
			// get messages
			List<List<String>> Messages = satellites.getSatellites().stream().map(t -> t.getMessage())
					.collect(Collectors.toList());

			response.put("position", geolocalizationService
					.getGeolocalization(new double[][] { { -500, -200 }, { 100, -100 }, { 500, 100 } }, distances));
			response.put("message", messageService.getMessage(Messages));
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("RESPONSE CODE:", "404");

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/topsecret_split")
	public ResponseEntity<?> topsecretSplitPost(@RequestBody Satellites satellites) {
		Map<String, Object> response = new HashMap<>();
		try {

			// get distances
			double[] distances = satellites.getSatellites().stream().map(t -> t.getDistance())
					.mapToDouble(Double::doubleValue).toArray();
			// get messages
			List<List<String>> Messages = satellites.getSatellites().stream().map(t -> t.getMessage())
					.collect(Collectors.toList());

			response.put("position", geolocalizationService
					.getGeolocalization(new double[][] { { -500, -200 }, { 100, -100 }, { 500, 100 } }, distances));
			response.put("message", messageService.getMessage(Messages));
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			
		} catch (Exception e) {
			response.put("error", "not enough information");

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
	}
}
