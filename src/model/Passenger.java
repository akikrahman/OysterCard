package model;

public class Passenger {

	private String name;
	private OysterCard card;
	private Journey journey;

	public Passenger(String name) {
		this.name = name;
		this.journey = new Journey();
	}

	public void addOysterCard(OysterCard card) {
		this.card = card;
	}

	public void addBalance(double amount) {

		this.card.addBalance(amount);

	}

	public double getBalance() {

		return this.card.getBalance();

	}

	public String getName() {
		return name;
	}

	public void deductBalance(double amount) {
		this.card.deductBalance(amount);

	}

	public Journey getJourney() {
		return journey;
	}

	public void setJourney(Journey journey) {
		this.journey = journey;
	}

	public void TouchOysterCardToReader(Station station, Transport transport) {

		if (journey.getStarted()) {
			// end journey and get fare
			double fare = journey.endJourney(station, transport);
			card.deductBalance(fare);
			card.addBalance(Fare.MAX_FARE);
			journey.setStarted(false);

		} else {
			if (transport == transport.BUS) {
				card.deductBalance(1.0);
				journey.setStart(station);
				journey.setTransport(transport);
			} else {

				journey.setStarted(true);
				journey.setStart(station);
				journey.setTransport(transport);
				card.deductBalance(Fare.MAX_FARE);
			}
		}

	}

}
