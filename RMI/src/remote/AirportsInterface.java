package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import AirportData.AirportDataProto.Airport;

public interface AirportsInterface extends Remote {
	public List<Airport> getNearestAirports(double longitude, double latitude) throws RemoteException;
}