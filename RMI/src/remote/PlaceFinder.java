package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import PlaceData.PlaceDataProto.Place;
import PlaceData.PlaceDataProto.PlaceList;

public class PlaceFinder extends UnicastRemoteObject implements PlaceFinderInterface {

	private static final long serialVersionUID = 1L;
	private PlaceList placeList;

	public PlaceFinder(PlaceList placeList) throws RemoteException { 
		this.placeList = placeList;
	}

	/**
	 * Gets the place from the place list. Returns null if no place is found.
	 * @param String city
	 * @param String state
	 * @return Place
	 */
	public Place findPlace(String city, String state) {
		for (Place p: placeList.getPlaceList()) {
			if (city.equals(p.getName()) && state.equals(p.getState())) {
				return p;
			}
		}
		return null;
	}

}
