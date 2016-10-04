package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import AirportData.AirportDataProto.Airport;

public interface AirportFinderInterface extends Remote {
	public List<Airport> getNearestAirports(double longitude, double latitude) throws RemoteException;
}
