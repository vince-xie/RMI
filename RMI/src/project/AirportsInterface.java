package project;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author Vincent Xie, Edmond Wu
 */
public interface AirportsInterface extends Remote {
	public List<AirportDistance> getNearestAirports(double latitude, double longitude) throws RemoteException;
}
