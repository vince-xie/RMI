package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

import PlaceData.PlaceDataProto.Place;

/**
 * @author Vincent Xie, Edmond Wu
 */
public interface PlacesInterface extends Remote {
	public Place findPlace(String city, String state) throws RemoteException;
}
