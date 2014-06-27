package samples;

import java.util.Scanner;

public class J203 {

	public static void main(String[] args) {
		
		//This program determines the even factorial of an even positive integer
		//ie: n(n-2)(n-4)....4*2
		
		int positiveInt;
		Scanner input = new Scanner(System.in);
		
		for (;;) {
			
			System.out.print("Please enter a positive even integer (0 to exit): ");
			positiveInt = input.nextInt();
			
			if (positiveInt == 0) {
				//terminal value
				break;
				
			} else if (positiveInt < 0) { //no negative values permitted
				
				System.out.println("The number entered is negative.");
				
			} else if ((positiveInt%2) != 0) { //no odd numbers permitted
				
				System.out.println("The number entered in not an even number.");
				
			} else {
				//for even positive numbers, call the method even_factorial and display the results
				System.out.println("The factorial value of " + positiveInt + " is " + even_factorial(positiveInt) + ".");
			}
		}
		
		input.close();

	}
	
	public static int even_factorial(int positiveInt) {

		int temp, result;
		
		result = 1;
		temp = positiveInt;
		
		if (temp < 4) {
			//if the number is less than 4, the even factorial is simply 2
			return (2);
			
		} else {
			
			while (temp != 0) {
				//while n (temp) is not zero, multiple the result 
				//with the value and then decrease the value of temp by 2 for the
				//next iteration
				result *= temp;
				
				temp -= 2;
			}
			
			return (result);
		}
	}
}
	
	
	
	
	
	
	
	
