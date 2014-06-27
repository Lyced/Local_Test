package samples;

import java.util.Scanner;

public class J201 {

	public static void main(String[] args) {
		
		//Program that takes in an integer value and determines whether it is a zero value or not
		
		int n;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		n = input.nextInt();
		
		if (iZ_zero(n) == 'z') {
			
			System.out.print("You have entered the number zero");
			
		} else {
			
			System.out.print("You did not enter the number zero");
			
		}
		
		input.close();

	}
	
	public static char iZ_zero(int n) {
		
		//A rather roundabout way of determining whether a value is zero or not by returning char values that
		//will be interpreted in the main function
		
		if (n == 0) {
			
			System.out.println("z");
			return 'z';
			
		} else {
			
			System.out.println("n");
			return 'n';
		}
		
	}

}
