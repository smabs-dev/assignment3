package com.meritamerica.assignment3;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class BankAccount {
		protected static SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
		
		protected long accountNumber;
		protected double balance;
		protected double interestRate;
		protected Date openedOn;
		
	
	BankAccount(double balance, double interestRate){
		this(balance, interestRate, new Date());
	}
	BankAccount(double balance, double interestRate, Date accountOpenedOn){
		this(MeritBank.getNextAccountNumber(), balance, interestRate, accountOpenedOn);
	}
	BankAccount(long accountNumber, double balance, double interestRate, Date accountOpenedOn){
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.openedOn = accountOpenedOn;
	}
	long getAccountNumber() { return accountNumber; }
	double getBalance() { return balance; }
	public double getInterestRate() { return interestRate; }
	Date getOpenedOn() { return openedOn; }
	
	boolean withdraw(double amount) {
		if (amount<balance) {
			System.out.println(balance-amount);
			balance = balance - amount;
			return true;
		} else return false;
	}
	public boolean deposit(double amount) {
		if (amount>0) {
			System.out.println(balance+amount);
			balance = balance+amount;
			return true;
		}else return false;
	}
	static BankAccount readFromString(String accountData) throws ParseException{
	
		String[] data = accountData.split(",");
		
		long accountNumber = Long.parseLong(data[0]);
		double balance = Double.parseDouble(data[1]);
		double interestRate = Double.parseDouble(data[2]);
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/DD/YYYY");
		Date openedOn = sdf2.parse(data[3]);
		
		BankAccount ba = new BankAccount(accountNumber, balance, interestRate, openedOn);
		return ba;
	}
	
	String writeToString() {
		StringBuilder sb = new StringBuilder();
		sb.append(accountNumber);
		sb.append(',');
		sb.append(balance);
		sb.append(',');
		sb.append(interestRate);
		sb.append(',');
		sb.append(sdf.format(openedOn));
		return sb.toString();
	}
	public double futureValue(int years) {
			double factor = 1+interestRate;
			return Math.pow(factor, years) * balance;
	}
}
//bank account(double balance, double interest rate)
//bank account(double balance, double interest rate. java.util.date accountopened)
//BankAccount(long accountNumber, double balance, double interestRate, 
//^java.util.Date accountOpenedOn)
//java.util.Date getOpenedOn()
//static BankAccount readFromString(String accountData) throws ParseException
//Should throw a java.lang.NumberFormatException if String cannot be correctly parsed
//String writeToString()
