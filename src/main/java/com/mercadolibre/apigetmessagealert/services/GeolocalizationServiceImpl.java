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
	/**
	 * funcion encargada de triangular una coordenada teniendo en cuenta las
	 * coordenadas y distancias recibidas por parametro. para determinar la
	 * coordenada se hace uso de la
	 * libreria:<artifactId>trilateration</artifactId><version>1.0.2</version> la
	 * cual contiene la logica para obtener la cordenada resultante.
	 * 
	 * @return coordenada
	 */
	@Override
	public Geolocalization getGeolocalization(double[][] positions, double[] distances) {

		NonLinearLeastSquaresSolver solver = new NonLinearLeastSquaresSolver(
				new TrilaterationFunction(positions, distances), new LevenbergMarquardtOptimizer());
		Optimum optimum = solver.solve();

		double[] centroid = optimum.getPoint().toArray();

		return new Geolocalization((double) Math.round(centroid[0] * 100d) / 100d,
				(double) Math.round(centroid[1] * 100d) / 100d);
	}

}
