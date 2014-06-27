package samples;

import java.util.Scanner;

public class J206 {

	public static void main(String[] args) {
		
		//program returns the minimum value in a list of value entered by the user
		
		int i;
		Scanner input = new Scanner(System.in);
		
		for (;;) {
			
			System.out.print("Please enter the number of expected values (0 to exit): ");
			i = input.nextInt();
			
			if (i == 0) {
				//terminal value cause there's not value expected to be entered
				break;
				
			} else {
				//passes the number of expected values and the scanner to the min method to get
				//the actual user values
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
				min = temp; //assign the first value entered as the minimum value in the list
			}
			
			if (temp < min) {
				min = temp;
			}
			
		}
		
		return min;
	}

}
