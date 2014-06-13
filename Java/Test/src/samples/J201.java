package samples;

import java.util.Scanner;

public class J201 {

	public static void main(String[] args) {
		
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
		
		if (n == 0) {
			
			System.out.println("z");
			return 'z';
			
		} else {
			
			System.out.println("n");
			return 'n';
		}
		
	}

}
