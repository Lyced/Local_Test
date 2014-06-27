package samples;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

public class J400 {
	
	//program to determine the whether a bank is safe given a limit threshold and its assets
	
	public static void main(String []arg) throws IOException{
		
		int numBanks, i, loanCount;
		double limit;
		Bank[] bankList;
		Stack<Integer> unsafeBanks = new Stack<Integer>();
		String filepath;
		Scanner fileinput = new Scanner(System.in);
		Scanner input = null;
		
		try {
			
			//gets the location of the file containing the number of banks, limits, and their loan dependencies
			System.out.print("Please enter the location of the bank data file: ");
			filepath = fileinput.nextLine(); 
			
			//create and open a file reader to read the values of the file specified by the user
			input = new Scanner(new BufferedReader (new FileReader (filepath)));
			
			numBanks = input.nextInt();
			limit = input.nextDouble();
			
			//create an array of bank objects given number of banks provided by the file
			bankList = new Bank[numBanks];
			
			for (i = 0; i < numBanks; i++) {
			
				bankList[i] = new Bank(); //create a new bank object in each cell of the bankList array
				
				bankList[i].baseBalance = input.nextDouble();
				bankList[i].numLoans = input.nextInt();
				
				//given the number of loans a specific bank has, create and initialize the loan list for that bank
				bankList[i].initializeLoanList();
				
				for (loanCount = 0; loanCount < bankList[i].numLoans; loanCount++) {
					
					//for the number of loans that the bank has, fill the relevant data
					bankList[i].loanList[loanCount].loanee = input.nextInt();
					bankList[i].loanList[loanCount].amount = input.nextDouble();
					
				}
			} 
			
		} finally {
				
			//closing the scanners at the end
			if (input != null) {
				input.close();
			}
				
			if (fileinput != null) {
				fileinput.close();
			}
		}
		
		//once all the bank data has been populated, check to see which banks are unsafe given the limit imposed
		//via the findUnsafe method and the values returned in a stack.
		//alternatively, the values can be returned as an array for a more permanent storage solution
		unsafeBanks = findUnsafe(bankList, limit, unsafeBanks);
		
		System.out.print("The following banks are unsafe: ");

		//outputs which banks are unsafe
		while (!unsafeBanks.empty()) {
			
			System.out.print(unsafeBanks.pop() + " ");
			
		}
		
		System.out.println(".");
			
	}

	public static Stack<Integer> findUnsafe(Bank[] bankList, double limit, Stack<Integer> unsafeBanks) {
		
		int c, l;
		boolean stateChanged = true; //initialization as true to get the logic going
		
		//if there's been a change in state, primarily a bank in the list has been flagged as unsafe
		//start from the beginning and check again
		//SOME OPTIMIZATION WORK CAN BE DONE HERE SO THE PROGRAM DOESN'T HAVE TO LOOP THROUGH EVERYTHING IF A
		//BANK IS UNSAFE
		while (stateChanged) {
		
			for (c = 0; c < bankList.length; c++) {
				
				if (bankList[c].unsafe == false) { //for the banks that have not been flagged as unsafe...
				
					bankList[c].currentBalance = bankList[c].baseBalance; //set the base balance as the current balance
					
					for (l = 0; l <bankList[c].loanList.length; l++) {
					
						//add the value of all loans the bank has given out to the the current balance
						bankList[c].currentBalance += bankList[c].loanList[l].amount;
						
					}
					
					System.out.println("Bank " + c + " current balance is " + bankList[c].currentBalance + ".");
					
					//checks if the balance of the bank is under the limit
					if (bankList[c].currentBalance < limit) {
						
						//if under the limit, the bank is pushed in the stack and flagged as unsafe
						unsafeBanks.push(c);
						bankList[c].unsafe = true;
						stateChanged = true; //flags that there's been a change in the bankList and the program should recalculate the values of all the banks again
						updateUnsafe(bankList, c); //calls a method that goes through the bankList and invalidates the loan amounts other banks have given to the unsafe bank
						break;
						
					} else {
						
						//all the banks have been checked if they are safe or not
						stateChanged = false;
						
					}
				}
			}
		}
		
		return unsafeBanks; //returns the stack of unsafe banks to main
	}
	
	public static void updateUnsafe(Bank[] bankList, int c) {
		
		int u, ul;
		
		//for a given unsafe bank...
		for (u = 0; u < bankList.length; u++) {
			
			//going through all the over bank's loan list...
			for (ul = 0; ul < bankList[u].loanList.length; ul++) {
			
				//and if they are on the loan list...
				if (bankList[u].loanList[ul].loanee == c) {
					
					System.out.println("Bank " + u +"'s loan to " + bankList[u].loanList[ul].loanee + " for amount " + bankList[u].loanList[ul].amount + " has been invalidated.");
					
					//set it to zero (not preferable)
					bankList[u].loanList[ul].amount = 0;
					
				}
			
			}
		}
	}
	
	private static class Bank { //nested class that contains all the elements for a bank
		
		int numLoans, l;
		double baseBalance, currentBalance;
		boolean unsafe;
		Loanee[] loanList;  //First array contains which bank the loan was given to and the second one is of the amount loaned.
		
		public Bank(){
			numLoans = 0;
			baseBalance = 0;
			currentBalance = 0;
			unsafe = false;
		}
			
		public void initializeLoanList () {
			
			//method that creates the array in which the loan data is stored and initialize it
			
			loanList = new Loanee[numLoans];
			
			for (l = 0; l< numLoans; l++) {
				
				loanList[l] = new Loanee();
				
				loanList[l].loanee = 0;
				loanList[l].amount = 0;
				
			}
		}
		/*
		public void showData() {
			
			//method that displays all the information for a bank
			
			System.out.println("The bank balance is: " + currentBalance);
			System.out.println("The bank gave out " + numLoans + " loans.");
			
			for (l = 0; l < numLoans; l++) {
				
				System.out.println("Loan " + (l + 1) + " is bank " + loanList[l].loanee + " with a loan amount of $" + loanList[l].amount + ".");
				
			}
			
			System.out.println();
		} */
		
	}
	
	
	private static class Loanee { //nested class that contains elements of a loan
		
		int loanee;
		double amount;
		
		public Loanee() {
			
			loanee = 0;
			amount = 0;
			
		}
		
	}
}