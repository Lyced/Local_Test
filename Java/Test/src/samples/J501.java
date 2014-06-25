package samples;

import java.util.Scanner;

public class J501 {

	public static void main(String[] args) {
		
		int a, b, holding;
		Scanner input = new Scanner(System.in);

		for(;;) {
			
			System.out.print("Please enter two integer parameters (0 to exit): ");
			a = input.nextInt();
			b = input.nextInt();
			
			if (a < b) {
				
				holding = a;
				a = b;
				b = holding;
				
			} else if (a == 0 && b == 0) {
				
				break;
			}
			
			System.out.println("The GCD of values " + a + " and " + b + " is " + gcd(a,b) +".");
			
		}
		
		input.close();
		
	}
	
	public static int gcd(int x, int y) {
		
		if (y != 0) {
		
			return gcd(y,(x % y));
			
		}
		
		return x;
		
	}

}
