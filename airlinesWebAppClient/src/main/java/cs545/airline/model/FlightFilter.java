package cs545.airline.model;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped

public class FlightFilter implements Serializable{
	private String airlineName;
	private String originAirport;
	private String destinationAirport;
	private String departureDate;
	private String departureTime;
	private String arrivalDate;
	private String arrivalTime;
	
	public FlightFilter(){
		
	}
	
	public FlightFilter(String airlineName, String originAirport, String destinationAirport, String departureDate, String departureTime, String arrivalDate, String arrivalTime){
		this.airlineName = airlineName;
		this.originAirport = originAirport;
		this.destinationAirport = originAirport;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
	}
	
	public String getAirlineName(){
		return airlineName;
	}
	
	public void setAirlineName(String airlineName){
		this.airlineName = airlineName;
	}
	
	public String getOriginAirport(){
		return originAirport;
	}
	
	public void setOriginAirport(String originAirport){
		this.originAirport = originAirport;
	}
	
	public String getDestinationAirport(){
		return destinationAirport;
	}
	
	public void setDestinationAirport(String destinationAirport){
		this.destinationAirport = destinationAirport;
	}
	
	public String getDepartureDate(){
		return departureDate;
	}
	
	public void setDepartureDate(String departureDate){
		this.departureDate = departureDate;
	}
	
	public String getDepartureTime(){
		return departureTime;
	}
	
	public void setDepartureTime(String departureTime){
		this.departureTime = departureTime;
	}
	
	public String getArrivalDate(){
		return arrivalDate;
	}
	
	public void setArrivalDate(String arrivalDate){
		this.arrivalDate = arrivalDate;
	}
	
	public String getArrivalTime(){
		return arrivalTime;
	}
	
	public void setArrivalTime(String arrivalTime){
		this.arrivalTime = arrivalTime;
	}
}
