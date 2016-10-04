package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import AirportData.AirportDataProto.Airport;
import AirportData.AirportDataProto.AirportList;

public class Airports extends UnicastRemoteObject implements AirportsInterface {

	private static final long serialVersionUID = 1L;
	private AirportList airportList;

	public Airports(AirportList airportList) throws RemoteException {
		this.airportList = airportList;
	}

	/**
	 * Gets a list of the nearest airports to the specified longitude and latitude.
	 * @param double longitude
	 * @param double latitude
	 * @return List of nearest airports
	 */
	public List<Airport> getNearestAirports(double longitude, double latitude) {
		return new ArrayList<Airport>();
	}
}