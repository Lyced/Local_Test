package samples;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

public class J400 {
	
	public static void main(String []arg) throws IOException{
		
		int numBanks, i, loanCount;
		double limit;
		Bank[] bankList;
		Stack<Integer> unsafeBanks = new Stack<Integer>();
		String filepath;
		Scanner fileinput = new Scanner(System.in);
		Scanner input = null;
		
		try {
			
			System.out.print("Please enter the location of the bank data file: ");
			filepath = fileinput.nextLine();
			
			input = new Scanner(new BufferedReader (new FileReader (filepath)));
			
			numBanks = input.nextInt();
			limit = input.nextDouble();
			
			bankList = new Bank[numBanks];
			
			for (i = 0; i < numBanks; i++) {
			
				bankList[i] = new Bank(); 
				
			//	System.out.print("Please enter the bank balance: ");
				bankList[i].baseBalance = input.nextDouble();
								
			//	System.out.print("Please enter the number of loans this bank gave out: ");
				bankList[i].numLoans = input.nextInt();
				
				bankList[i].initializeLoanList();
				
				for (loanCount = 0; loanCount < bankList[i].numLoans; loanCount++) {
					
			//		System.out.print("Please enter the bank and the loaned amount: ");
					bankList[i].loanList[loanCount].loanee = input.nextInt();
					bankList[i].loanList[loanCount].amount = input.nextDouble();
					
				}
			} 
			
		} finally {
				
				if (input != null) {
					input.close();
				}
				
				if (fileinput != null) {
					fileinput.close();
				}
		}
		/*	
		for (i = 0; i < numBanks; i++) {
				
			System.out.println("The bankID is: " + i);
			bankList[i].showData();
																							
		}
		*/
		unsafeBanks = findUnsafe(bankList, limit, unsafeBanks);
		
		System.out.print("The following banks are unsafe: ");

		while (!unsafeBanks.empty()) {
			
			System.out.print(unsafeBanks.pop() + " ");
			
		}
		
		System.out.println(".");
			
	}

	public static Stack<Integer> findUnsafe(Bank[] bankList, double limit, Stack<Integer> unsafeBanks) {
		
		int c, l;
		boolean stateChanged = true;
		
		while (stateChanged) {
		
			for (c = 0; c < bankList.length; c++) {
				
				if (bankList[c].unsafe == false) {
				
					bankList[c].currentBalance = bankList[c].baseBalance;
					
					for (l = 0; l <bankList[c].loanList.length; l++) {
					
						bankList[c].currentBalance += bankList[c].loanList[l].amount;
						
					}
					
					System.out.println("Bank " + c + " current balance is " + bankList[c].currentBalance + ".");
					
					if (bankList[c].currentBalance < limit) {
						
						unsafeBanks.push(c);
						bankList[c].unsafe = true;
						stateChanged = true;
						updateUnsafe(bankList, c);
						break;
						
					} else {
						
						stateChanged = false;
						
					}
				}
			}
		}
		
		return unsafeBanks;
	}
	
	public static void updateUnsafe(Bank[] bankList, int c) {
		
		int u, ul;
		
		for (u = 0; u < bankList.length; u++) {
			
			for (ul = 0; ul < bankList[u].loanList.length; ul++) {
			
				if (bankList[u].loanList[ul].loanee == c) {
					
					System.out.println("Bank " + u +"'s loan to " + bankList[u].loanList[ul].loanee + " for amount " + bankList[u].loanList[ul].amount + " has been invalidated.");
					
					bankList[u].loanList[ul].amount = 0;
					
				}
			
			}
		}
	}
	
	private static class Bank {
		
		int numLoans, l;
		double baseBalance, currentBalance;
		boolean unsafe;
		Loanee[] loanList;  //First array contains the bankID of the loanee and the second one is of the amount loaned.
		
		public Bank(){
			numLoans = 0;
			baseBalance = 0;
			currentBalance = 0;
			unsafe = false;
		}
			
		public void initializeLoanList () {
			
			loanList = new Loanee[numLoans];
			
			for (l = 0; l< numLoans; l++) {
				
				loanList[l] = new Loanee();
				
				loanList[l].loanee = 0;
				loanList[l].amount = 0;
				
			}
		}
		
		public void showData() {
			
			System.out.println("The bank balance is: " + currentBalance);
			System.out.println("The bank gave out " + numLoans + " loans.");
			
			for (l = 0; l < numLoans; l++) {
				
				System.out.println("Loan " + (l + 1) + " is bank " + loanList[l].loanee + " with a loan amount of $" + loanList[l].amount + ".");
				
			}
			
			System.out.println();
		}
		
	}
	
	
	private static class Loanee {
		
		int loanee;
		double amount;
		
		public Loanee() {
			
			loanee = 0;
			amount = 0;
			
		}
		
	}
}