package com.meritamerica.assignment3;

public class CDOffering {
	int year;
	double interestRate;
	static CDOffering readFromString(String cdOfferingDataString) {
		this.year = term;
		this.interestRate = interestRate;
	}
public static CDOffering readFromString(String accountData) throws ParseException{
	java.lang.NumberFormatException
		String[] chunks = accountData.split(",");
		return new CDOffering(
				Long.parseDouble(chunks[0]),
				Double.parseDouble(chunks[1]),
				Double.parseDouble(chunks[2]),
				sdf.parse(chunks[3]),
				Integer.parseInt(chunks[4]));
	}
	public int getTerm() {return year;}
	public double getInterestRate() {return interestRate;}

	public String writeToString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.writeToStrong());
		sb.append(',');
		sb.append(term);
		return sb.toString();
	}
}
//should be possible to read below information from a file
// Description
//term
//interest rate

//ammend
/*
Add the following methods to the CDOffering class:-
static CDOffering readFromString(String cdOfferingDataString)-
Should throw a java.lang.NumberFormatException if String cannot be correctly parsed-
String writeToString()-
*/