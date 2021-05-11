package com.meritamerica.assignment3;

import java.sql.Date;

public class CheckingAccount extends BankAccount {
	CheckingAccount(double openingBalance){
		super(openingBalance, .0001);
	}
	private CheckingAccount(long accountNumber, double balance, double interestRate, Date openedOn) {
		super(accountNumber, balance, interestRate, openedOn);
	}
	static CheckingAccount readFromString(String accountData) throws ParseException{
		String[] chunks = accountData.split(',');
		
		return new CheckingAccount(Long.parseLong(chunks[0]), Double.parseDouble(chunks[1]), Double.parseDouble(chunks[2]), sdf.parse(chunks[3]));
	}
}
//account number
//current balance
//interest rate
//date account opened

//amend
/*Create appropriate constructors
static CheckingAccount readFromString(String accountData) 
		throws ParseException
Should throw a java.lang.NumberFormatException if String cannot be correctly parsed
*/
