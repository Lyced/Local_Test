package samples;

import java.util.Scanner;
import java.lang.Math;

public class J209 {

	//program to draw rectangles of x height and 6 character width with random characters
	
	public static void main(String[] args) {
		
		int n = -1;
		char ch1, ch2;
		
		Scanner input = new Scanner(System.in);
		
		for (;;) {
			
			System.out.print("Please enter a non-negative value (0 to exit): ");
			n = input.nextInt(); //gets the height of the rectangle from the user
			
			if (n == 0) {
				//terminal value since a rectangle of 0 height isn't a rectangle...
				break;
				
			} else if (n > 0) {
				
				ch1 = (char) (Math.random() * 100); //gets a random character for the sides via RNG
				ch2 = (char) (Math.random() * 100);
				
				//passes the height and the randomly generated characters to the method
				//to actually draw it out in the console
				my_rectangle(n, ch1, ch2); 
				
			}
		}
		
		input.close();
	}
	
	public static void my_rectangle(int n, char ch1, char ch2) {
	
		//drawing pretty rectangles
		
		int temp = n;
		
		System.out.println("" + ch1 + ch1 + ch1 + ch1 + ch1 + ch1);

		while (temp != 0) {
			System.out.println(ch2 + "    " + ch2);
			temp--;
		}
		
		System.out.println(""+ch1+ch1+ch1+ch1+ch1+ch1);
	}

}
