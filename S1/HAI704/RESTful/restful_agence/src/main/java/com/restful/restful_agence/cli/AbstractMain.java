package com.restful.restful_agence.cli;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class AbstractMain {
    public static String SERVICE_URL;
    public static final String QUIT = "0";

    protected void setTestServiceUrl(BufferedReader inputReader) throws IOException {
		System.out.println("Provide URL to the WebService");
        SERVICE_URL = "http://localhost:8080/hotelwebservice/api";

		while(!validServiceUrl()) {
			System.err.println("Error: "+ SERVICE_URL + " is not a valid REST URL. Try again: ");
			SERVICE_URL = inputReader.readLine();
		}
    }

    protected abstract boolean validServiceUrl();

    protected abstract void menu();

}