import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;

import AirportData.AirportDataProto.AirportList;
import remote.Airports;

/**
 * @author Vincent Xie, Edmond Wu
 */
public class AirportServer {

	private static final int DEFAULT_PORT = 1099;
	
	/**
	 * Retrieves airport list from file.
	 * @param filename
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @return AirportList
	 */
	public static AirportList getAirportListFromFile(String filename) throws IOException {
		return AirportList.parseFrom(new FileInputStream(filename));
	}

    public static void main(String[] args) {
    	int port = DEFAULT_PORT;
    	if (args.length > 0) {
    	    try {
			    port = Integer.parseInt(args[0]);
		    } catch (NumberFormatException e) {
		    	System.err.println("usage: java AirportServer port");
		    	System.exit(1);
		    }
    	}

    	AirportList airportList;
    	try {
    	    airportList = getAirportListFromFile("airports-proto.bin");
    	} catch (FileNotFoundException e) {
    		System.out.println("Airport file not found.");
    		return;
        } catch (IOException e) {
    		System.out.println("Error parsing airport list.");
    		return;
    	}

    	String url = "//localhost:" + port + "/Airports";
    	try {
			Naming.rebind(url, new Airports(airportList));
			System.out.println("Airport server is running on " + url + ".");
		} catch (Exception e) {
			System.out.println("Airport server startup failed.");
		}
	}
}
