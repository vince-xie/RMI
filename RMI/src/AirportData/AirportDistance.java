package AirportData;

import java.io.Serializable;

import AirportData.AirportDataProto.Airport;

/**
 * @author Vincent Xie, Edmond Wu
 */
public class AirportDistance implements Serializable {

	private static final long serialVersionUID = 1L;

	private Airport airport;
	private double distance;

	public AirportDistance(Airport airport, double distance) {
		this.airport = airport;
		this.distance = distance;
	}

	public Airport getAirport() {
		return airport;
	}

	public double getDistance() {
		return distance;
	}
}
