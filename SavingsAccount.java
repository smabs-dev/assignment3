package com.meritamerica.assignment3;

import java.util.Arrays;

public class SavingsAccount extends BankAccount {
	CheckingAccount(double openingBalance){
		super(openingBalance, .0001);
	}
	private SavingsAccount(long accountNumber, double balance, double interestRate, Date openedOn) {
		super(accountNumber, balance, interestRate, openedOn);
	}
	static SavingsAccount readFromString(String accoutData) throws ParseException{
		String[] chunks = accountData.split(',');
		
		return new SavingsAccount(Long.parseLong(chunksp[0]), Double.parseDouble(chunks[1]), Double.parseDouble(chunks[2]), sdf.parse(chunks[3]));
	}
}

// should be possible to read below information from a file
//account number - account number adds a random 10 digit number to an array of account numbers, then checks if its a duplicate of any other number 
//current balance - saves to the file for each account
//interest rate - per account saved to the file
//date account opened - "

//ammend
/*
SavingsAccount
Create appropriate constructors
static SavingsAccount readFromString(String accountData) throws ParseException
Should throw a java.lang.NumberFormatException if String cannot be correctly parsed
