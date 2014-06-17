package samples;

import java.util.Scanner;

public class J203 {

	public static void main(String[] args) {
		
		int positiveInt;
		Scanner input = new Scanner(System.in);
		
		for (;;) {
			
			System.out.print("Please enter a positive even integer (0 to exit): ");
			positiveInt = input.nextInt();
			
			if (positiveInt == 0) {
				
				break;
				
			} else if (positiveInt < 0) {
				
				System.out.println("The number entered is negative.");
				
			} else if ((positiveInt%2) != 0) {
				
				System.out.println("The number entered in not an even number.");
				
			} else {
				
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
			
			return (2);
			
		} else {
			
			while (temp > 2) {
				
				result *= temp;
				
				temp -= 2;
			}
			
			return (result * 2);
		}
	}
}
	
	
	
	
	
	
	
	
