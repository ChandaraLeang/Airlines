package edu.mum.cs545.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cs545.airline.dao.AirplaneDao;
import cs545.airline.model.Airplane;
import cs545.airline.service.AirplaneService;

@Path("/airplane")
public class AirplaneRest {
	private AirplaneService airplaneService = new AirplaneService(new AirplaneDao());
	
	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Airplane> findAll(){
		return airplaneService.findAll();
	}
}
