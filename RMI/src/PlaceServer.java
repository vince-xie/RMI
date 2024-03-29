import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Naming;

import PlaceData.PlaceDataProto.PlaceList;
import remote.Places;

/**
 * @author Vincent Xie, Edmond Wu
 */
public class PlaceServer {

	private static final int DEFAULT_PORT = 1099;
	
	/**
	 * Retrieves place list from file.
	 * @param filename
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @return PlaceList
	 */
	public static PlaceList getPlaceListFromFile(String filename) throws IOException {
		return PlaceList.parseFrom(new FileInputStream(filename));
	}

    public static void main(String[] args) {
    	int port = DEFAULT_PORT;
    	if (args.length > 0) {
    	    try {
			    port = Integer.parseInt(args[0]);
		    } catch (NumberFormatException e) {
		    	System.err.println("usage: java PlaceServer port");
		    	System.exit(1);
		    }
    	}

    	PlaceList placeList;
    	try {
    	    placeList = getPlaceListFromFile("places-proto.bin");
    	} catch (FileNotFoundException e) {
    		System.out.println("Places file not found.");
    		return;
        } catch (IOException e) {
    		System.out.println("Error parsing place list.");
    		return;
    	}

    	String url = "//localhost:" + port + "/Places";
    	try {
			Naming.rebind(url, new Places(placeList));
			System.out.println("Place server is running on " + url + ".");
		} catch (Exception e) {
			System.out.println("Place server startup failed.");
		}
	}
}
