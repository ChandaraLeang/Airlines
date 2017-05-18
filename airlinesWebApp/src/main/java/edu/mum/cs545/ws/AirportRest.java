package edu.mum.cs545.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cs545.airline.dao.AirportDao;
import cs545.airline.model.Airport;
import cs545.airline.service.AirportService;

@Path("/airport")
public class AirportRest {
	private AirportService airportService = new AirportService(new AirportDao());
	
	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Airport> findAll(){
		return airportService.findAll();
	}
}