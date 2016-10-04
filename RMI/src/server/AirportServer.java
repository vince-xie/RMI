package server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import AirportData.AirportDataProto.AirportList;

/**
 * @author Vincent Xie, Edmond Wu
 */
public class AirportServer {

	/**
	 * Retrieves airport list from file.
	 * @param filename
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @return AirportList
	 */
	private static AirportList getAirportListFromFile(String filename) throws FileNotFoundException, IOException {
		return AirportList.parseFrom(new FileInputStream(filename));
	}

    public static void main(String[] args) {
    	AirportList airportList;
    	try {
    	    airportList = getAirportListFromFile("airports-proto.bin");
    	} catch(Exception e) {
    		System.out.println("Error parsing airport list.");
    		return;
    	}
	}
}
