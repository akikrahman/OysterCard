package model;

public enum Station {
	
	HOLBORN(1,0), EARLSCOURT(1,2), WIMBLEDON(3,0), HAMMERSMITH(2,0);
	
	int zone1, zone2;
	
	Station(int zone1, int zone2){
		this.zone1 = zone1;
		this.zone2 = zone2;
	}
	
	public int[] getZones() {
		int[] arr = {zone1,zone2};
		return arr;
	}

}
