package samples;

import java.util.Scanner;

public class J205 {

	public static void main(String[] arg) {
		
		//program to determine the average value of a list of integers entered
		
		int i;
		Scanner input = new Scanner(System.in);
		
		for (;;) {
			
			System.out.print("Please enter the number of entries expected (0 to exit): ");
			i = input.nextInt(); //gets the number of values expected in the list
			
			if (i == 0 ) {
				//terminal value cause there are not values expected to be entered
				break;
				
			} else {
				//passes the number of values to be expected as well as the scanner to the average
				//method to get the actual values
				System.out.println("The average is " + average(i, input) + ".");
			
			}
		}
		
		input.close();
	}
	
	public static double average(int i, Scanner input) {
		
		double total = 0;
		int numEntries = i;
		
		while (numEntries != 0) {
			//gets user input values
			System.out.print("Please enter a number: ");
			total += input.nextDouble(); //adds the value to the total
			numEntries--;
			
		}
		
		return (total/i); //returns the average
		
	}
}
