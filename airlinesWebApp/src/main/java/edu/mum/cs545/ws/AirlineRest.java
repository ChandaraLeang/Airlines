package edu.mum.cs545.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cs545.airline.dao.AirlineDao;
import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

@Path("/airline")
public class AirlineRest {
	private AirlineService airlineService = new AirlineService(new AirlineDao());
	
	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Airline> findAll() {
		return airlineService.findAll();
	}
	
	@Path("/create")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes
	public void create(Airline airline){
		airlineService.create(airline);
	}
	
	@Path("/update")
	@PUT
	@Produces(MediaType.APPLICATION_XML)
	@Consumes
	public Airline update(Airline airline){
		return airlineService.update(airline);
	}
	
	@Path("/delete/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_XML)
	@Consumes
	public void delete(@PathParam("id") int id){
		Airline airline = new Airline();
		airline.setId(id);
		airlineService.delete(airline);
	}
}
