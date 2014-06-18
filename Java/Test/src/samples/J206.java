package samples;

import java.util.Scanner;

public class J206 {

	public static void main(String[] args) {
		
		int i;
		Scanner input = new Scanner(System.in);
		
		for (;;) {
			
			System.out.print("Please enter the number of expected values (0 to exit): ");
			i = input.nextInt();
			
			if (i == 0) {
				
				break;
				
			} else {
			
				System.out.println("The minimum value inputted was " + min(i, input) + ".");
			
			}
		}
		
		input.close();
	}
	
	
	public static double min(int i, Scanner input) {
		
		double temp, min = 0;
		int n;
		
		for (n = 0; n < i; n++) {
			
			System.out.print("Enter a number: ");
			temp = input.nextDouble();
			
			if (n == 0) {
				min = temp;
			}
			
			if (temp < min) {
				min = temp;
			}
			
		}
		
		return min;
	}

}
