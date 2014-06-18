package samples;

import java.util.Scanner;

public class J205 {

	public static void main(String[] arg) {
		
		int i;
		Scanner input = new Scanner(System.in);
		
		for (;;) {
			
			System.out.print("Please enter the number of entries expected (0 to exit): ");
			i = input.nextInt();
			
			if (i == 0 ) {
				
				break;
				
			} else {
			
				System.out.println("The average is " + average(i, input) + ".");
			
			}
		}
		
		input.close();
	}
	
	public static double average(int i, Scanner input) {
		
		double total = 0;
		int numEntries = i;
		
		while (numEntries != 0) {
			
			System.out.print("Please enter a number: ");
			total += input.nextDouble();
			numEntries--;
			
		}
		
		return (total/i);
		
	}
}
