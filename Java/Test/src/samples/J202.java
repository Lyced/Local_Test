package samples;

import java.util.Scanner;

public class J202 {

	public static void main(String[] args) {
		
		//Program that determines whether a value is special or not.
		//Criteria of special-ness is a positive integer that is: 
		//a) divisible by 4
		//b) divisible by 100 and 400, else not special
		
		int n;
		Scanner input = new Scanner(System.in);
		
		for(;;) {
		
			System.out.print("Please enter an integer (0 to exit): ");
			
			n = input.nextInt();
			
			if (n < 0) {
				
				System.out.println("The integer entered cannot be negative.");
				
			} else if (n == 0) {
				//terminal value
				break;
				
			} else {
				//valid values get passed to the is_special method
				is_special(n);
				
			}
		}
		
		input.close();
	}

	
	public static void is_special (int n) {
		
		if ((n%4) == 0) { //if the number is divisible by 4 then...
			
			if (((n%100) == 0) && ((n%400) != 0)) { //check if the number is also divisible by 100 and 400
				
				System.out.println("The number " + n + " is not special."); //if not the following message is displayed
				
			} else {
				
				System.out.println("The number " + n + " is special."); //else if the number is indeed divisible by 100 and 400..
			}
			
		} else {
			
			System.out.println("The number " + n + " is not special."); //else if the number is just divisible by 4
			
		}
	}
}
