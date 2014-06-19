package samples;

import java.util.Scanner;
import java.lang.Math;

public class J209 {

	public static void main(String[] args) {
		
		int n = -1;
		char ch1, ch2;
		
		Scanner input = new Scanner(System.in);
		
		for (;;) {
			
			System.out.print("Please enter a non-negative value (0 to exit): ");
			n = input.nextInt();
			
			if (n == 0) {
				
				break;
				
			} else if (n > 0) {
				
				ch1 = (char) (Math.random() * 100);
				ch2 = (char) (Math.random() * 100);
				
				my_rectangle(n, ch1, ch2);
				
			}
		}
		
		input.close();
	}
	
	public static void my_rectangle(int n, char ch1, char ch2) {
	
		int temp = n;
		
		System.out.println("" + ch1 + ch1 + ch1 + ch1 + ch1 + ch1);

		while (temp != 0) {
			System.out.println(ch2 + "    " + ch2);
			temp--;
		}
		
		System.out.println(""+ch1+ch1+ch1+ch1+ch1+ch1);
	}

}
