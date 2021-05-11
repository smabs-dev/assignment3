package com.meritamerica.assignment3;

import java.text.ParseException;
import java.util.Date;

public class CDAccount extends BankAccount {
	private int term;
	
	private CDAccount(long accountNumber, double balance, double interestRate, startDate, int term) {
		super(accountNumber, balance, interestRate, startDate);
		this.term = term;
	}
	
	private (CDOffering cdoffering, double balance) {
		super(balance, offering.getInterestRate());
		this.term = offering.getTerm();
	}
	boolean withdraw(double amount) {
		return false;
	}
	boolean deposit(double amount) {
		return false;
	}
	
	public CDAccount(CDOffering cdoffering, double balance) {
		super(balance, cdoffering.getInterestRate());
		this.cdoffering = cdoffering;
	}
	int getTerm() {
		return cdoffering.getTerm();
	}
	public static CDAccount readFromString(String accountData) throws ParseException{
		String[] chunks = accountData.split(",");
		return new CDAccount(
				Long.parseDouble(chunks[0]),
				Double.parseDouble(chunks[1]),
				Double.parseDouble(chunks[2]),
				sdf.parse(chunks[3]),
				Integer.parseInt(chunks[4]));
	}
	@Override
	public String writeToString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.writeToStrong());
		sb.append(',');
		sb.append(term);
		return sb.toString();
	}
	
}
//account number
//opening balance
//term
//interest rate
//date account opened

//ammend
/*CDAccount
Create appropriate constructors
Override the deposit and withdraw methods to return false (CD Accounts cannot deposit new funds or withdraw funds until the term is reached)
static CDAccount readFromString(String accountData) throws ParseException
Should throw a java.lang.NumberFormatException if String cannot be correctly parsed
Override writeToString method to include term
*/