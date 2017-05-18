package edu.mum.cs545.restClient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Flight;

@Named("flightRestClient")
@ApplicationScoped
public class FlightRestClient {
	private Flight flight = new Flight();
	
	public Flight getFlight(){
		return this.flight;
	}
	
	public List<Flight> findAll(){
		Client client = ClientBuilder.newClient();
		
		List<Flight> allFlights= client.target("http://localhost:8080/airlinesWebApp/rs/flight/list")
				.request(MediaType.APPLICATION_XML)
				.get(new GenericType<List<Flight>>(){});
		
		return allFlights;
	}
	
	public List<Flight> filterFlight(String departureDate, String departureTime, String arrivalDate, String arrivalTime, String name, String origin, String destination){
		List<Flight> temp = new ArrayList<Flight>();
		Client client = ClientBuilder.newClient();
		
		List<Flight> flight2 = client.target("http://localhost:8080/airlinesWebApp/rs/flight/list")
		.request(MediaType.APPLICATION_XML)
		.get(new GenericType<List<Flight>>(){});
		
		for(Flight f: flight2){
			if((f.getDepartureDate().contains(departureDate)) &&
			   (f.getDepartureTime().contains(departureTime)) &&
			   (f.getArrivalDate().contains(arrivalDate)) &&
			   (f.getArrivalTime().contains(arrivalTime)) &&
			   (f.getAirline().getName().toLowerCase().contains(name)) && 
			   (f.getOrigin().getName().toLowerCase().contains(origin)) &&
			   (f.getDestination().getName().toLowerCase().contains(destination))){
				temp.add(f);
			}
		}
		
		return temp;
	}
}