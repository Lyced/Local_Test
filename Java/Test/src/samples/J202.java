package samples;

import java.util.Scanner;

public class J202 {

	public static void main(String[] args) {
		
		int n;
		Scanner input = new Scanner(System.in);
		
		for(;;) {
		
			System.out.print("Please enter an integer (0 to exit): ");
			
			n = input.nextInt();
			
			if (n < 0) {
				
				System.out.println("The integer entered cannot be negative.");
				
			} else if (n == 0) {
				
				break;
				
			} else {
				
				is_special(n);
				
			}
		}
		
		input.close();
	}

	
	public static void is_special (int n) {
		
		if ((n%4) == 0) {
			
			if (((n%100) == 0) && ((n%400) != 0)) {
				
				System.out.println("The number " + n + " is not special.");
				
			} else {
				
				System.out.println("The number " + n + " is special.");
			}
			
		} else {
			
			System.out.println("The number " + n + " is not special.");
			
		}
	}
}
