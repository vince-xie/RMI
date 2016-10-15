package project;

import java.rmi.Remote;
import java.rmi.RemoteException;

import project.PlaceDataProto.Place;

/**
 * @author Vincent Xie, Edmond Wu
 */
public interface PlacesInterface extends Remote {
	public Place findPlace(String city, String state) throws RemoteException;
}
