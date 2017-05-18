package edu.mum.cs545.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cs545.airline.dao.FlightDao;
import cs545.airline.model.Airline;
import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

@Path("/flight")
public class FlightRest {
	private FlightService flightService = new FlightService(new FlightDao());
	
	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Flight> findAll(){
		return flightService.findAll();
	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	public List<Flight> findByAirline(Airline airline){
//		return flightService.findByAirline(airline);
//	}
}
