package model;

public class Journey {
	
	private Station start, stop;
	private Transport transport;
	private Boolean started;

	
	public Journey() {
		this.started = false;
	}
	
	public Boolean getStarted() {
		return started; 
	}

	public void setStarted(Boolean status) {
		this.started = status;
	}

	public void startJourney(Station station, Transport transport) {
		this.start = station;
		this.transport = transport;
	}
	
	public double endJourney(Station station, Transport transport) {
		stop = station;
		return Fare.calculateFare(transport, start, stop);
	}	
	
	public Station getStop() {
		return stop;
	}

	public void setStop(Station stop) {
		this.stop = stop;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public Station getStart() {
		return start;
	}

	public void setStart(Station start) {
		this.start = start;
	}

}
