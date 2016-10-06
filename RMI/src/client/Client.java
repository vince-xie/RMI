package client;

import java.rmi.Naming;
import java.io.*;
import java.util.*;

/**
 * @author Vincent Xie, Edmond Wu
 */
public class Client {
    public static void main(String[] args) {
    	if (args.length == 0) {
    		return;
    	}
    	for (String s : args) {
    		System.out.println(s);
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
    	System.out.println("City: " + city + ", State: " + state + ", Server: " + server + ", Port: " + port);
    }
}
