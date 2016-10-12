package client;

import java.rmi.*;
import java.util.*;

import AirportData.AirportDataProto.*;
import AirportData.AirportDistance;
import PlaceData.PlaceDataProto.Place;
import remote.*;

/**
 * @author Vincent Xie, Edmond Wu
 */
public class Client {
    public static void main(String[] args) {
    	if (args.length == 0) {
    		return;
    	}
    	int port = 1099;
    	String server = "localhost";
    	int argLength = args.length;
    	String city = args[argLength - 2];
    	String state = args[argLength - 1];
    	List<String> arguments = Arrays.asList(args);
    	if (arguments.contains("-h")) {
    		server = arguments.get(arguments.indexOf("-h") + 1);
    	}
    	if (arguments.contains("-p")) {
    		port = Integer.parseInt(arguments.get(arguments.indexOf("-p") + 1));
    	}
    	String airportUrl = "// " + server + ":" + port + "/Airports";
    	String placeUrl = "// " + server + ":" + port + "/Places";
    	    	
    	try {
			Places places = (Places)Naming.lookup(placeUrl);
			Place place = places.findPlace(city, state);
			if (place == null) {
				System.out.println("Invalid place");
			}
			else {
				double latitude = place.getLat(), longitude = place.getLon();
				System.out.println("Place: " + place.getName() + ", " + state + ": " + latitude + ", " + longitude);
				try {
					Airports airports = (Airports)Naming.lookup(airportUrl);
					List<AirportDistance> closestAirports = airports.getNearestAirports(latitude, longitude);
					for (AirportDistance a : closestAirports) {
						Airport airport = a.getAirport();
						int distance = (int)a.getDistance();
						System.out.println("code=" + airport.getCode() + ", name=" + airport.getName() + ", state=" + airport.getState() + " distance: " + distance + " miles");
					}
				} catch (Exception e) {
					System.out.println("Airports lookup failed");
				}
			}
		} catch (Exception e) {
			System.out.println("Place lookup failed");
		} 
    }
}
