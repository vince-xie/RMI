package project;

import java.rmi.*;
import java.util.*;

import project.AirportDataProto.*;
import project.PlaceDataProto.*;

/**
 * @author Vincent Xie, Edmond Wu
 */
public class Client {
    public static void main(String[] args) {
    	if (args.length < 2 || args.length > 6) {
    		System.out.println("Invalid amount of arguments!");
    		return;
    	}
    	int port = 1099;
    	String server = "localhost";
    	String city = args[args.length - 2];
    	String state = args[args.length - 1];
    	if (state.length() != 2) {
    		System.out.println("Invalid state input (use state 2-letter code)");
    		return;
    	}
    	List<String> arguments = Arrays.asList(args);
    	if (arguments.contains("-h")) {
    		server = arguments.get(arguments.indexOf("-h") + 1);
    	}
    	if (arguments.contains("-p")) {
    		port = Integer.parseInt(arguments.get(arguments.indexOf("-p") + 1));
    	}
    	String airportUrl = "// " + server + ":" + port + "/Airports";
    	String placeUrl = "// " + server + ":" + port + "/Places";
    	
    	//local testing purposes
    	/*
    	try {
    		PlaceList pl = PlaceServer.getPlaceListFromFile("places-proto.bin");
    		Places places = new Places(pl);
    		AirportList ap = AirportServer.getAirportListFromFile("airports-proto.bin");
    		Airports airports = new Airports(ap);
    		Place p = places.findPlace(city, state);
    		List<AirportDistance> closest = airports.getNearestAirports(p.getLat(), p.getLon());
    		System.out.println(p.getName() + ", " + p.getState() + ": " + p.getLat() + ", " + p.getLon());
    		for (AirportDistance a : closest) {
				Airport airport = a.getAirport();
				int distance = (int)Math.round(a.getDistance());
				System.out.println("code=" + airport.getCode() + ", name=" + airport.getName() + ", state=" + airport.getState() + " distance: " + distance + " miles");
			}
    	} catch (Exception e) {
    		System.out.println("Parsing error");
    	}
<<<<<<< HEAD:RMI/src/project/Client.java
    	*/
=======
    	
    	//using the server
>>>>>>> 00c579a7f5885ddda6e88e167c754849f0f3e9db:RMI/src/client/Client.java
    	try {
    		Places places = (Places)Naming.lookup(placeUrl);
    		Place place = places.findPlace(city, state);
			if (place == null) {
				System.out.println("Invalid place");
			}
			else {
				try {
					Airports airports = (Airports)Naming.lookup(airportUrl);
					List<AirportDistance> closestAirports = airports.getNearestAirports(place.getLat(), place.getLon());
					System.out.println(place.getName() + ", " + place.getState() + ": " + place.getLat() + ", " + place.getLon());
					for (AirportDistance a : closestAirports) {
						Airport airport = a.getAirport();
						int distance = (int)Math.round(a.getDistance());
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
