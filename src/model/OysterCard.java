package model;

public class OysterCard {
	
	private double balance;
	
	public OysterCard(double amount) {
		this.balance = amount;
	}

	public void addBalance(double amount) {
		this.balance += amount;
		
	}

	public double getBalance() {
		return this.balance;
		
	}

	public void deductBalance(double amount) {
		this.balance -= amount;
		
	}
	

}
