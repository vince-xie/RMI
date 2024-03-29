package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import PlaceData.PlaceDataProto.Place;
import PlaceData.PlaceDataProto.PlaceList;

/**
 * @author Vincent Xie, Edmond Wu
 */
public class Places extends UnicastRemoteObject implements PlacesInterface {

	private static final long serialVersionUID = 1L;
	private PlaceList placeList;

	public Places(PlaceList placeList) throws RemoteException { 
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
			if (city.regionMatches(true, 0, p.getName(), 0, city.length()) && state.equalsIgnoreCase(p.getState())) {
				return p;
			}
		}
		return null;
	}

}
