package project;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import project.AirportDataProto.Airport;
import project.AirportDataProto.AirportList;

import static java.util.Comparator.comparing;
import static project.DistanceCalculator.calculateDistance;

/**
 * @author Vincent Xie, Edmond Wu
 */
public class Airports extends UnicastRemoteObject implements AirportsInterface {

	private static final long serialVersionUID = 1L;
	private AirportList airportList;

	public Airports(AirportList airportList) throws RemoteException {
		this.airportList = airportList;
	}

	/**
	 * Gets a list of the nearest airports to the specified longitude and latitude.
	 * @param latitude
	 * @param longitude
	 * @return List of nearest airports
	 */
	public List<AirportDistance> getNearestAirports(double latitude, double longitude) {
		List<AirportDistance> nearestAirports = new ArrayList<AirportDistance>();
		int highestIndex = 0;
		double highestDistance = -1;
		for (Airport a: airportList.getAirportList()) {
			double distance = calculateDistance(latitude, longitude, a);
            if (nearestAirports.size() < 5) {
            	nearestAirports.add(new AirportDistance(a, distance));
            	if (distance > highestDistance) {
            		highestIndex = nearestAirports.size() - 1;
            		highestDistance = distance;
            	}
            } else {
            	if (distance < highestDistance) {
            		nearestAirports.set(highestIndex, new AirportDistance(a, distance));
            		highestIndex = 0;
                	highestDistance = -1;
                	for (int i = 0; i < nearestAirports.size(); i++) {
                		double d = nearestAirports.get(i).getDistance();
                		if (d > highestDistance) {
                			highestIndex = i;
                			highestDistance = d;
                		}
                	}
            	} 
            }
        }
		nearestAirports.sort(comparing(AirportDistance::getDistance));
		return nearestAirports;
	}
}
