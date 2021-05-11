package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class MeritBank {

	static void addAccountHolder(AccountHolder accountHolder) {
		AccountHolder[] temp = new AccountHolder[accountHolders.length + 1];
		for (int i = 0; i < accountHolders.length; i++) {
			temp[i] = accountHolders[i];
		}
			temp[temp.length - 1] = accountHolder;
				accountHolders = temp;
	}
	

	static AccountHolder[] accountHolders = {};
		

	static AccountHolder[] getAccountHolders() {
		return accountHolders;
	}

	static CDOffering[] getCDOfferings() {
		return cdOfferings;
	}

	static CDOffering getBestCDOffering(double depositAmount) {
		double bestIR = -1;
		CDOffering bestCDO = null;
		for (int i = 0; i < cdOfferings.length; i++) {
			CDOffering cdo = cdOfferings[i];
			double interestRate = cdo.getInterestRate();
			if (interestRate > bestIR) {
				bestIR = interestRate;
				bestCDO = cdo;
			}
		}
		return bestCDO;
	}
	static CDOffering getSecondBestCDOffering(double depositAmount) {
		double bestIR = -1;
		CDOffering secondCDO = null; 
		CDOffering bestCDO = null;
		for (int i = 0; i < cdOfferings.length; i++) {
			CDOffering cdo = cdOfferings[i];
			double interestRate = cdo.getInterestRate();
			if (interestRate > bestIR) {
				bestIR = interestRate;
				secondCDO = bestCDO;
				bestCDO = cdo;
			}
		}
		return secondCDO;
	}
	static void clearCDOfferings() {
		cdOfferings = new CDOffering[0];
	}

	static void setCDOfferings(CDOffering[] offerings) {
		cdOfferings = offerings;
	}

	private static CDOffering[] cdOfferings = {};

	static long getNextAccountNumber() {
		accountNumber++;
		return accountNumber;
	}
	static long accountNumber;
	
	static double totalBalances() {
		double CombinedBalance = 0;
		for (int i = 0; i < accountHolders.length; i++) {
			AccountHolder accHolder = accountHolders[i];
			CombinedBalance = CombinedBalance + accHolder.getCombinedBalance();
		}
		return CombinedBalance;
	}
	static double futureValue(double presentValue, double interestRate, int term) {
			double factor = 1+interestRate;
			return Math.pow(factor, term) * presentValue;
	}
	static void setNextAccountNumber(long nextAccountNumber) {
		accountNumber = nextAccountNumber;
	}
	static AccountHolder[] sortAccountHolders() {
		Arrays.sort(accountHolders) ;
		return accountHolders;
	}
	static boolean writeToFile(String fileName) {
		try { 
		FileWriter accRecords = new FileWriter(fileName);
		PrintWriter printRecords = new PrintWriter(accRecords);
		printRecords.println(getNextAccountNumber());
		
		printRecords.println(getCDOfferings().length);
		for (int i = 0; i < cdOfferings.length; i++) {
			CDOffering cdo = cdOfferings[i];
		printRecords.println(cdo.writeToString());
		}
		
		printRecords.println(accountHolders.length);
		for (int i = 0; i < accountHolders.length; i++) {
			AccountHolder accHolder = accountHolders[i];
		printRecords.println(accHolder.writeToString());
		}
		
		return true;
			}
		catch(IOException err) {
			err.printStackTrace();
			return false;
		}
	}
	static boolean readFromFile(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
			setNextAccountNumber(Long.parseLong(br.readLine()));
			String line = br.readLine();
			int numCDOfferings = Integar.parseInt(br.readLine());
			CDOffering[] tempCDOs = new CDOffering[numCDOfferings];
			for (int i = 0; i < numbCDOfferings; i++) {
					tempCDOs[i] = CDOffering.readFromString(br.readLine())
			}
			setCDOfferings(tempCDOs);
			
			int numAccountHolders = Integar.parseInt(br.readLine);
			for (int i = 0; i < numAccountHolders; i++) {
				StringWriter sw - new StringWriter();
				
				try (PrintWriter pw = new PrintWriter(sw)){
					pw.println()br.readLine());
					int numCAs = Integer.parseInt(br.read());
					pw.println(numCAs);
					for (int j = 0; j < numCAs; j++) {
						pw.println(br.readLine());
					}
					int numSAs = Integer.parseInt(br.read());
					pw.println(numSAs);
					for (int j = 0; j < numSAs; j++) {
						pw.println(br.readLine());
					}
					int numCDAs = Integer.parseInt(br.read());
					pw.println(numCDAs);
					for (int j = 0; j < numCDAs; j++) {
						pw.println(br.readLine());
					}
				}
				addAccountHolder(AccountHolder.readFromString(sw.toString()));
			}
			return true;
		}
				catch (IOException err) {
					err.printStackTrace();
					return false;
			}
		}
	}
//should be able to read below information from the file
//List of account holders
//List of CD Offerings
//Next account number

//ammend
/*Add the following methods to the MeritBank class:
static boolean readFromFile(String fileName)
static boolean writeToFile(String fileName)
static AccountHolder[] sortAccountHolders()
static void setNextAccountNumber(long nextAccountNumber) -
*/