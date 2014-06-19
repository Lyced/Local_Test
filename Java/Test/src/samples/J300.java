package samples;

import java.util.Scanner;

public class J300 {

	public static void main(String[] args) {
		
		int size;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the size of the game (even integer between 2 and 52): ");
		size = input.nextInt();
		
		if (size < 2 || size > 2) {
			
			System.out.println("Value entered is not valid.");
			
		} else if ((size%2) != 0) {
			
			System.out.println("The number entered is not an even number.");
			
		} else { 
			
			create_array(size);
			shuffle_array();
		}
		
		
	}
	
	public static void create_array(int size) {
		
	}

	public static void shuffle_array() {
		
	}
	
	public static void play() {
		
	}

}
