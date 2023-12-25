package oop4;

public class BankAccount {
	private String accountNumber;
	private int balance;
	
	public void deposit(double money) {
		if(balance>0) {
			balance=(int) (balance+money);
		}
	}
	
	public void withdraw(double money) {
		if(balance>0 && balance-money>=0) {
			balance=(int) (balance-money);
		}
	}
}
