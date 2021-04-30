package model;

public class Fare {

	public static double MAX_FARE=3.2;
	
	public static double calculateFare(Transport transport, Station start, Station stop) {

		int[] startZone = start.getZones();
		int[] endZone = stop.getZones();
		double fare = 0.0;

		//highest fare possible first
		if ((startZone[0] == 1 && endZone[0] == 2) || (startZone[0] == 1 && endZone[0] == 3))
			fare = 3.0;
		
		if ((startZone[0] == 2 && endZone[0] == 1) || (startZone[0] == 3 && endZone[0] == 1))
			fare = 3.0;

		//both station in zone 1
		if (startZone[0] == 1 && endZone[0] == 1)
			fare = 2.0;

		//a station in both zone 1 and zone 2
		if (startZone[0] == 1 && endZone[1] == 2)
			fare = 2.5;
		// reverse of above
		if (startZone[1] == 2 && endZone[0] == 1)
			fare = 2.5;
		
		//any travel outside zone 1
		if (startZone[0] != 1 && endZone[0] != 1)
			fare = 2;
		
		if ((startZone[1] == 2 && endZone[0] == 2) || (startZone[1] == 2 && endZone[0] == 3))
			fare = 2.0;
	
		
		return fare;
	}

}
