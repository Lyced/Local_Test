package samples;

import java.util.Scanner;

public class J400 {
	
	public static void main(String []arg) {
		
		int numBanks, i, loanCount;
		double limit;
		Bank[] bankList;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the number of banks and the limit: ");
		numBanks = input.nextInt();
		limit = input.nextDouble();
		
		bankList = new Bank[numBanks];
		
		for (i = 0; i < numBanks; i++) {
		
			bankList[i] = new Bank(); 
			
			System.out.print("Please enter the bank balance: ");
			bankList[i].balance = input.nextDouble();
			
			System.out.print("Please enter the number of loans this bank gave out: ");
			bankList[i].numLoans = input.nextInt();
			
			bankList[i].initializeLoanList();
			
			for (loanCount = 0; loanCount < bankList[i].numLoans; loanCount++) {
				
				System.out.print("Please enter the bank and the loaned amount: ");
				bankList[i].loanList[loanCount].loanee = input.nextInt();
				bankList[i].loanList[loanCount].amount = input.nextDouble();
				
			}
		}
		
		for (i = 0; i < numBanks; i++) {
			
			System.out.println("The bankID is: " + i);
			bankList[i].showData();
			
		}
			
		input.close();
	}

	private static class Bank {
		
		int numLoans, l;
		double balance;
		loanee[] loanList;  //First array contains the bankID of the loanee and the second one is of the amount loaned.
		
		public Bank(){
			numLoans = 0;
			balance = 0;
		}
			
		public void initializeLoanList () {
			
			loanList = new loanee[numLoans];
			
			for (l = 0; l< numLoans; l++) {
				
				loanList[l] = new loanee();
				
				loanList[l].loanee = 0;
				loanList[l].amount = 0;
				
			}
		}
		
		public void showData() {
			
			System.out.println("The bank balance is: " + balance);
			System.out.println("The bank gave out " + numLoans + " loans.");
			
			for (l = 0; l < numLoans; l++) {
				
				System.out.println("Loan " + (l + 1) + " is bank " + loanList[l].loanee + " with a loan amount of $" + loanList[l].amount + ".");
				System.out.println();
			}
			
		}
		
	}
	
	
	private static class loanee {
		
		int loanee;
		double amount;
		
		public loanee() {
			
			loanee = 0;
			amount = 0;
			
		}
		
	}
}