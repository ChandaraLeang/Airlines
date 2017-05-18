package edu.mum.cs545.restClient;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import cs545.airline.model.Airline;

@Named("airlineRestClient")
@ApplicationScoped
public class AirlineRestClient {
	
	private Airline airline = new Airline();
	
	public Airline getAirline(){
		return this.airline;
	}
	
	public List<Airline> findAll(){
		Client client = ClientBuilder.newClient();
		
		List<Airline> allAirlines= client.target("http://localhost:8080/airlinesWebApp/rs/airline/list")
				.request(MediaType.APPLICATION_XML)
				.get(new GenericType<List<Airline>>(){});
		
		return allAirlines;
	}
	
	public void create(){
		airline = new Airline(airline.getName());
		Client client = ClientBuilder.newClient();
		
		client.target("http://localhost:8080/airlinesWebApp/rs/airline/create")
			.request(MediaType.APPLICATION_XML)
			.post(Entity.xml(airline));
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("airlineList.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update(long id, String name){
		airline = new Airline();
		airline.setId(id);
		airline.setName(name);
		Client client = ClientBuilder.newClient();
		
		client.target("http://localhost:8080/airlinesWebApp/rs/airline/update")
			.request(MediaType.APPLICATION_XML)
			.put(Entity.xml(airline));
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("airlineList.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id){
		Client client = ClientBuilder.newClient();
		
		client.target("http://localhost:8080/airlinesWebApp/rs/airline/delete/" + id)
			.request(MediaType.APPLICATION_XML)
			.delete();
	}
}
