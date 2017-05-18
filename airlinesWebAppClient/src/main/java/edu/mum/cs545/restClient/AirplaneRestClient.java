package edu.mum.cs545.restClient;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Airplane;

@Named("airplaneRestClient")
@ApplicationScoped
public class AirplaneRestClient {
	
	public List<Airplane> findAll(){
		Client client = ClientBuilder.newClient();
		
		List<Airplane> allAirplanes= client.target("http://localhost:8080/airlinesWebApp/rs/airplane/list")
				.request(MediaType.APPLICATION_XML)
				.get(new GenericType<List<Airplane>>(){});
		
		return allAirplanes;
	}
}
