package project;

import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toDegrees;
import static java.lang.Math.toRadians;

import project.AirportDataProto.Airport;

/**
 * @author Vincent Xie, Edmond Wu
 */
public class DistanceCalculator {

	private static final double NAUTICAL_MILES_TO_MILES = 1.1507794;

	/**
	 * Calculates the distance to an airport from a certain longitude and latitude
	 * @param latitude
	 * @param longitude
	 * @param airport
	 * @return double distance in miles
	 */
	public static double calculateDistance(double latitude, double longitude, Airport airport) {
		double airportLat = toRadians(airport.getLat());
		double airportLon = toRadians(airport.getLon());
		double rlatitude = toRadians(latitude);
		double rlongitude = toRadians(longitude);
		return NAUTICAL_MILES_TO_MILES * 60 * toDegrees(acos(
				sin(rlatitude) * sin(airportLat) + cos(rlatitude) * cos(airportLat) * cos(airportLon - 
				rlongitude)));
	}

}
