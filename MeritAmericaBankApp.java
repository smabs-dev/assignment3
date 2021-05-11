package com.meritamerica.assignment3;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		MeritBank.readFromFile("src/test/testMeritBank_good.txt");
		MeritBank.writeToFile("src/test/testMeritBank_realGood.txt");
	}
}
//needs to read this information when the file is read
/*Next bank account number: 11
3 CD offerings
2 account holders 
John Doe
1 checking account
2 savings accounts
Jane S Doe
2 checking accounts
3 savings accounts
2 CD accounts
*/