package Entities;


public class Account {
	private int number;
	private String holder;
	private double balance;
	
	public Account(int number, String holder, double inicialDeposit) {
		deposit(inicialDeposit);
		this.holder = holder;
		this.number = number;
	}
	
	public Account(int number, String holder) {
		this.holder = holder;
		this.number = number;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		this.balance += amount;
	}
	public void withdraw(double amount) {
		this.balance -= amount + 5;
	}

	@Override
	public String toString() {
		return "Account [number=" + number + ", holder=" + holder + ", balance=" + balance + "]";
	}
	
	
}

