package server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

import PlaceData.PlaceDataProto.PlaceList;
import remote.Places;

/**
 * @author Vincent Xie, Edmond Wu
 */
public class PlaceServer {

	/**
	 * Retrieves place list from file.
	 * @param filename
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @return PlaceList
	 */
	private static PlaceList getPlaceListFromFile(String filename) throws FileNotFoundException, IOException {
		return PlaceList.parseFrom(new FileInputStream(filename));
	}

    public static void main(String[] args) {
    	PlaceList placeList;
    	try {
    	    placeList = getPlaceListFromFile("places-proto.bin");
    	} catch(Exception e) {
    		System.out.println("Error parsing place list.");
    		return;
    	}
	}
}
