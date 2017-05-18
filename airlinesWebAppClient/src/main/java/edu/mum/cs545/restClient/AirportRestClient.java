package edu.mum.cs545.restClient;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Airport;

@Named("airportRestClient")
@ApplicationScoped
public class AirportRestClient {
	
	public List<Airport> findAll(){
		Client client = ClientBuilder.newClient();
		
		List<Airport> allAirports= client.target("http://localhost:8080/airlinesWebApp/rs/airport/list")
				.request(MediaType.APPLICATION_XML)
				.get(new GenericType<List<Airport>>(){});
		
		return allAirports;
	}
}