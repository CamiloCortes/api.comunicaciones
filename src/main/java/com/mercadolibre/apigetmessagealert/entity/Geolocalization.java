package com.mercadolibre.apigetmessagealert.entity;
/**
 * 
 * @author ccortes5
 *
 */
public class Geolocalization {
	double X;
	double Y;
	
	
	public Geolocalization(double x, double y) {
		super();
		X = x;
		Y = y;
	}
	public double getX() {
		return X;
	}
	public void setX(double x) {
		X = x;
	}
	public double getY() {
		return Y;
	}
	public void setY(double y) {
		Y = y;
	}
	
	
}
