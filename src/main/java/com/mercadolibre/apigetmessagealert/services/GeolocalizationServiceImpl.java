package com.mercadolibre.apigetmessagealert.services;

import org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer.Optimum;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.stereotype.Service;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import com.mercadolibre.apigetmessagealert.entity.Geolocalization;

/**
 * clase tipo service en cargada de aplicar la logica de negocio necesaria para
 * triangular una pocicion teniendo en cuenta posiciones y distancias dadas
 * 
 * @author ccortes5
 *
 */
@Service
public class GeolocalizationServiceImpl implements IGeolocalizationService {

	@Override
	public Geolocalization getGeolocalization(double[][] positions, double[] distances) {

		NonLinearLeastSquaresSolver solver = new NonLinearLeastSquaresSolver(
				new TrilaterationFunction(positions, distances), new LevenbergMarquardtOptimizer());
		Optimum optimum = solver.solve();

		double[] centroid = optimum.getPoint().toArray();

		return new Geolocalization(centroid[0], centroid[1]);
	}

}
