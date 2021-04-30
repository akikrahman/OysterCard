package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.OysterCard;
import model.Passenger;
import model.Station;
import model.Transport;

class OysterCardTests {
	
	
	Passenger passenger;
	

	@BeforeEach
	void init() {
		passenger = new Passenger("Akik");
		passenger.addOysterCard(new OysterCard(30.0));

	}

	@Test
	void CheckPassengerCreation() {
		
		assertAll("checking passenger creation with card",
				() -> assertEquals("Akik", passenger.getName()),
				() -> assertEquals(30.0, passenger.getBalance())
		);

	}

	@Test
	void UpdateOysterCardBalance() {

		passenger.addBalance(5);
		assertEquals(35.0, passenger.getBalance());
		passenger.deductBalance(6);
		assertEquals(29.0, passenger.getBalance());
		
	}
	
	@Test
	void JourneyTest() {
		
		passenger.TouchOysterCardToReader(Station.HOLBORN, Transport.TUBE);
		
		assertAll("checking passenger touch with card",
				() -> assertEquals(true, passenger.getJourney().getStarted()),
				() -> assertEquals(Station.HOLBORN, passenger.getJourney().getStart()),
				() -> assertEquals(Transport.TUBE, passenger.getJourney().getTransport()),
				() -> assertEquals(26.80, passenger.getBalance())
		);
		
		passenger.TouchOysterCardToReader(Station.EARLSCOURT, Transport.TUBE);
		
		assertAll("checking passenger touch with card",
				() -> assertEquals(false, passenger.getJourney().getStarted()),
				() -> assertEquals(Station.EARLSCOURT, passenger.getJourney().getStop()),
				() -> assertEquals(Transport.TUBE, passenger.getJourney().getTransport()),
				() -> assertEquals(27.5, passenger.getBalance())
		);
		
		passenger.TouchOysterCardToReader(Station.EARLSCOURT, Transport.BUS);
		
		assertAll("checking passenger touch with card",
				() -> assertEquals(false, passenger.getJourney().getStarted()),
				() -> assertEquals(Station.EARLSCOURT, passenger.getJourney().getStop()),
				() -> assertEquals(Transport.BUS, passenger.getJourney().getTransport()),
				() -> assertEquals(26.5, passenger.getBalance())
		);
		
		passenger.TouchOysterCardToReader(Station.EARLSCOURT, Transport.TUBE);
		
		assertAll("checking passenger touch with card",
				() -> assertEquals(true, passenger.getJourney().getStarted()),
				() -> assertEquals(Station.EARLSCOURT, passenger.getJourney().getStart()),
				() -> assertEquals(Transport.TUBE, passenger.getJourney().getTransport()),
				() -> assertEquals(23.30, passenger.getBalance())
		);
		
		passenger.TouchOysterCardToReader(Station.HAMMERSMITH, Transport.TUBE);
		
		assertAll("checking passenger touch with card",
				() -> assertEquals(false, passenger.getJourney().getStarted()),
				() -> assertEquals(Station.HAMMERSMITH, passenger.getJourney().getStop()),
				() -> assertEquals(Transport.TUBE, passenger.getJourney().getTransport()),
				() -> assertEquals(24.5, passenger.getBalance())
		);
		
		
	}

}
