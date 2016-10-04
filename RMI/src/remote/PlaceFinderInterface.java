package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

import PlaceData.PlaceDataProto.Place;

public interface PlaceFinderInterface extends Remote {
	public Place findPlace(String city, String state) throws RemoteException;
}
