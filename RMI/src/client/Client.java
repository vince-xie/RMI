package client;

import java.rmi.Naming;
import java.io.*;

/**
 * @author Vincent Xie, Edmond Wu
 */
public class Client {
    public static void main(String[] args) {
    	int port = 1099;
    	int argLength = args.length;
    	String city = args[argLength - 2];
    	String state = args[argLength - 1];
    }
}
