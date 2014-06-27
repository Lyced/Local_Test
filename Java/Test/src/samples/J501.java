package samples;

import java.util.Scanner;

public class J501 {

	//program that determines the greatest common denominator/divisor between two integer values via recursion
	
	public static void main(String[] args) {
		
		int a, b, holding;
		Scanner input = new Scanner(System.in);

		for(;;) {
			
			System.out.print("Please enter two integer parameters (0 to exit): ");
			a = input.nextInt();
			b = input.nextInt();
			
			if (a < b) {
				
				//rearranging the values such that a is always bigger than b
				holding = a;
				a = b;
				b = holding;
				
			} else if (a == 0 && b == 0) {
				
				//terminal values
				break;
			}
			
			//pass the two integers to the gcd method
			System.out.println("The GCD of values " + a + " and " + b + " is " + gcd(a,b) +".");
			
		}
		
		input.close();
		
	}
	
	public static int gcd(int x, int y) {
		
		if (y != 0) {
		
			//if the remainder of the two values is not zero, then call the method again and pass the lower value 
			//of the two and the remainder
			return gcd(y,(x % y));
			
		}
		
		return x;
		
	}

}
