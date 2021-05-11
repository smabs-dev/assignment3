package com.meritamerica.assignment3;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

public class AccountHolder implements Comparable<AccountHolder>{
//instance variables	
	private String firstName;
	private String middleName; 
	private String lastName;
	private String ssn;
	private CheckingAccount[] checkingAccounts;
	private SavingsAccount[] savingsAccounts;
	private CDAccount[] cdAccounts;	
	
// special constructor
private AccountHolder(String firstName, String middleName, String lastName, String ssn){
	CheckingAccount[] checkingAccounts,
	SavingsAccount[] savingsAccounts,
	CDAccount[] cdAccounts() {
	this.firstName= firstName;
	this.middleName= middleName;
	this.lastName= lastName;
	this.ssn= ssn;
	this.checkingAccounts = checkingAccounts;
	this.savingsAccounts = savingsAccounts;
	this.cdAccounts = cdAccounts;
}
	
static void addAccountHolder(AccountHolder accountHolder) {
	AccountHolder[] temp = Arrays.copyOf(getAccountHolders(), accountHolders.length + 1);
	temp[temp.length - 1] = accountHolder;
	accountHolders = temp;
}	
static AccountHolder[] accountHolders;

static AccountHolder[] getAccountHolders() {
	return accountHolders;
}

public String getMiddleName() {return middleName;}
public CheckingAccount[] getCheckingAccounts() {return checkingAccounts;}
public SavingsAccount[] getSavingsAccounts() {return savingsAccounts;}
public String getFirstName() {return firstName;}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public void setMiddleName(String middleName) {
	this.middleName = middleName;
}
public String getLastName() {return lastName;}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getSSN() {
	return ssn;
}
public void setSSN(String ssn) {
	this.ssn = ssn;
}
static double totalBalances() {
	double CombinedBalance = 0;
	for (int i = 0; i < accountHolders.length; i++) {
		AccountHolder accHolder = accountHolders[i];
		CombinedBalance = CombinedBalance + accHolder.getCombinedBalance();
	}
	return CombinedBalance;
}
public CheckingAccount addCheckingAccount(double openingBalance) {
		if (openingBalance < 0.0){
			return null;
		}
		if (this.getCheckingBalance() + this.getSavingsBalance() >= 250000.0){
			return null;
		}
		CheckingAccount ca = new CheckingAccount(openingBalance);
		return addCheckingAccount(ca); 
	}
public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
		CheckingAccount[] temp = Arrays.copyOf(checkingAccounts, checkingAccounts.length + 1);
		temp[temp.length - 1] = checkingAccount;
		checkingAccounts = temp;
	return checkingAccount;
	}
public int getNumberOfCheckingAccounts() {
	return checkingAccounts.length;
	}
public int getNumberOfSavingsAccounts() {
	return savingsAccounts.length;
	}
public double getCheckingBalance() {
	double CombinedBalance = 0;
	for (int i = 0; i < checkingAccounts.length; i++) {
		CheckingAccount ca = checkingAccounts[i];
		CombinedBalance = CombinedBalance + ca.getBalance();
		}
	return CombinedBalance;
	}
public double getSavingsBalance() {
	double CombinedBalance = 0;
	for (int i = 0; i < savingsAccounts.length; i++) {
		SavingsAccount sa = savingsAccounts[i];
		CombinedBalance = CombinedBalance + sa.getBalance();
	}
	return CombinedBalance;
	}
public SavingsAccount addSavingsAccount(double openingBalance) {
		if (openingBalance<0.0){
			return null;
		}
		if (this.getCheckingBalance() + this.getSavingsBalance() >= 250000.0){
			return null;
		}
		SavingsAccount sa = new SavingsAccount(openingBalance);
		return addSavingsAccount(sa);
	}
public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
		SavingsAccount[] temp = Arrays.copyOf(savingsAccounts, savingsAccounts.length + 1);
		temp[temp.length - 1] = savingsAccount;
		savingsAccounts = temp;
	return savingsAccount;
	}
public double getCheckingAccountOpeningBalance() {
	return checkingAccountOpeningBalance;
	}
public void setCheckingAccountOpeningBalance(double checkingAccountOpeningBalance) {
	this.checkingAccountOpeningBalance = checkingAccountOpeningBalance;
	}
public double getSavingsAccountOpeningBalance() {
	return savingsAccountOpeningBalance;
	}
public void setSavingsAccountOpeningBalance(double savingsAccountOpeningBalance) {
	this.savingsAccountOpeningBalance = savingsAccountOpeningBalance;
	}
CDAccount addCDAccount(CDOffering offering, double openingBalance) {
	if (offering == null) {
			return null;
	}
	if (openingBalance<0.0){
			return null;
		}
		CDAccount cda = new CDAccount(offering, openingBalance);
		return addCDAccount(cda);
	}
CDAccount addCDAccount(CDAccount cdAccount) { 
		CDAccount[] temp = Arrays.copyOf(cdAccounts, cdAccounts.length + 1);
		temp[temp.length - 1] = cdAccount;
		cdAccounts = temp;
	return cdAccount;
	}
double getCDBalance() {
	double CDBalance = 0;
	for (int i = 0; i < cdAccounts.length; i++) {
		CDAccount cda = cdAccounts[i];
		CDBalance =  CDBalance + cda.getBalance();
	}
	return CDBalance;
	}
double getCombinedBalance() {
	return getCheckingBalance() + getSavingsBalance() + getCDBalance();
	}    
public CDAccount[] getCDAccounts() {
    return cdAccounts;
	}
public static AccountHolder readFromString(String accountHolderData) throws exception;
	Scanner scan = new Scanner(accountHolderData);
	
	String[] chunks = scan.nextLine().split(",");
	String lastName = chunks[0];
	String midName = chunks[1];
	String firstName = chunks[2];
	String ssn = chunks[3];
	
	int numCheckingAccounts = Integer.parseInt(scan.nextLine());
	CheckingAccount[] tempCAs = new CheckingAccount[numCheckingAccounts];
	for(int i = 0; i <numCheckingAccounts; i++)
		tempCAs[i] = CheckingAccount.readFromString(scan.nextLine());
}
	int numSavingsAccounts - Integer.parseInt(scan.nextLine());
	SavingsAccount[] tempSAs = new SavingsAccount[numSavingsAccounts];
	for (int i = 0; i < numCheckingAccounts; i++) {
		tempSAs[i] = SavingsAccount.readFromString(scan.nextLine());
	}
	int numCDAccounts = integer.parseInt(scan.nextLine());
	CDAccount[] tempSAs = new CDAccount[numSavingsAccounts];
	for (int i = 0; i < numCDAccounts; i++) {
		tempSAs[i] = CDAccount.readFromString(scan.nextLine());
	}
	scan.close();
	return new AccountHolder(firstName, middleName, lastName, ssn, tempCAs, tempSAs, tempCDAs);
}

private void writeAccountsToString(BankAccount[] accounts, PrintWriter pw) {
	pw.println(accounts.length);
	
	for (BankAccount ba : accounts) {
		pw.println(ba.writeToString());
	}
}
	
String writeToString() {
	StringWriter sw = new StringWriter();
	
	try (PrintWriter pw = new PrintWriter(sw)){
		pw.format("%s, %s, %s, %s", lastName, middleName, firstName, ssn).println();
		
		writeAccountsToString(checkingAccounts, pw);
		writeAccountsToString(savingsAccounts, pw);
		writeAccountsToString(cdAccounts, pw);
	}
	return sw.toString();
}


@Override
public int compareTo(AccountHolder otherAcc) {
	// TODO Auto-generated method stub
	double storedBalance = getCombinedBalance();
	double otherBalance = otherAcc.getCombinedBalance();
		if (otherBalance < storedBalance)
			return 1;
		else if (otherBalance > storedBalance)
			return -1;
		else
			return 0;
	}
	
}
// Account holder details
//list of checking accounts
//list of savings accounts
//list of cd acounts

//ammend
/*
mend the following class:
class AccountHolder implements Comparable<AccountHolder>
Implement the compareTo(AccountHolder otherAccountHolder) method such that account holders can be sorted by the combined balance of their accounts-
String writeToString()-
static AccountHolder readFromString(String accountHolderData) throws Exception-
Should throw a java.lang.Exception if String cannot be correctly parsed
*/