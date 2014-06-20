package samples;

import java.util.Scanner;
import java.lang.Math;
import java.io.IOException;

public class J300 {

	public static void main(String[] args) {
		
		int size;
		char YN;
		char[] gameArray;
		boolean[] flipped;
		Scanner input = new Scanner(System.in);
		
		for (;;) {
			
			System.out.print("Please enter the size of the game (even integer between 2 and 52): ");
			size = input.nextInt();
			
			while (!validate_size(size)){
				
				size = input.nextInt();
				
			}
			
			gameArray = new char[size];
			flipped = new boolean[size];
			
			create_array(gameArray, flipped);
	
			play_game(input, gameArray, flipped);
			
			System.out.print("Would you like to play another? Y/N: ");
			YN = input.next().charAt(0);
			
			if (YN == 'N' || YN == 'n') {
				
				break;
				
			}
		}
		
		input.close();
	}
	
	public static boolean validate_size(int size) {
		
		if (size < 2 || size > 52) {
			
			System.out.println("Value entered is not valid.");
			return false;
			
		} else if ((size%2) != 0) {
			
			System.out.println("The number entered is not an even number.");
			return false;
			
		} else { 
		
			return true;
			
		}
	}
	
	public static void create_array(char[] gameArray, boolean[] flipped) {
		
		int i, t = 0;
				
		for (i = 0; i <gameArray.length; i++) {
			
			gameArray[i] = (char)((int)('A') + t);
			gameArray[++i] = (char)((int)('A') + t);
			t++;
			
		}
		
		for (i = 0; i < flipped.length; i++) {
		
			flipped[i] = false;
			
		}
		
		shuffle_array(gameArray);	
		
	}

	public static void shuffle_array(char[] gameArray) {
		
		int s, swap1, swap2;
		char holding;
		
		for (s = 0; s != 1000; s++) {
			
			swap1 = (int)(gameArray.length * Math.random());
			swap2 = (int)(gameArray.length * Math.random());
			
			if (swap1 != swap2) {
				
				holding = gameArray[swap1];
				gameArray[swap1] = gameArray[swap2];
				gameArray[swap2] = holding;
				
			}
		}
	}
	
	public static void play_game(Scanner input, char[] gameArray, boolean[] flipped) {

		int pair1, pair2, boxesFlipped = 0, attempts = 0;
		boolean gameFinished = false;
		
		while (!gameFinished) {

			drawOutput(gameArray, flipped);
			
			System.out.print("Please enter which two boxes you would like to flip: ");
			pair1 = input.nextInt();
			pair2 = input.nextInt();
			
			if ((pair1 - 1) < 0 || (pair2 - 1) < 0 || (pair1 - 1) > gameArray.length || (pair2 - 1) > gameArray.length) {
			
				System.out.println("The values entered are outside the valid range.");
				
			} else if (flipped[pair1 - 1] == true || flipped[pair2 - 1] == true) {
				
				System.out.println("Values entered are already used.");
				
			} else {
				
				if (check_pairing(pair1, pair2, gameArray)){
					
					flipped[pair1 - 1] = true;
					flipped[pair2 - 1] = true;
					boxesFlipped += 2;
					
				}
				
				if (boxesFlipped == gameArray.length) {
					
					gameFinished = true;
					
				} else {
					
					showOutput(pair1, pair2, gameArray, flipped);
					
				}
				
				attempts++;
			}
		}
		
		drawOutput(gameArray, flipped);
		System.out.println("Game finished with " + attempts + " attempts.");
		System.out.println("That is " + (attempts - (gameArray.length)/2) + " more than the best possible result.");
		
	}
	
	public static boolean check_pairing(int pair1, int pair2, char[] gameArray) {
		
		if (gameArray[pair1 - 1] == gameArray[pair2 - 1]) {
			
			return true;
			
		} else {
			
			return false;
			
		}
	}
	
	public static void showOutput(int pair1, int pair2, char[] gameArray, boolean[] flipped) {
		
		int space, d, l = 1;
		
		for (d = 0; d < gameArray.length; d++) {
			
			if (d == (pair1 - 1) || d == (pair2 - 1)  || flipped[d]) {
				
				System.out.print(" " + gameArray[d] + " ");
				
			} else {
				
				System.out.print(" *");
				
			}
		}
		
		System.out.println();
		
		for (d = 0; d < gameArray.length; d++) {
			
			System.out.print(" " + l++);
			
		}
				
		System.out.println();
		
		System.out.println("Press enter to continue.");
		
		
		try {
			
			System.in.read();
			
		} catch (IOException e) {
		
			System.out.println("User read error.");
		
		}
		
		for (space = 0; space < 5; space ++) {
			
			System.out.println();
			
		}
		
	}
	
	public static void drawOutput(char[] gameArray, boolean[] flipped) {
		
		int d, l = 1;
	
		for (d = 0; d < gameArray.length; d++) {
			
			if (flipped[d]) {
				
				System.out.print(" " + gameArray[d] + " ");
				
			} else {
				
				System.out.print(" *");
				
			}
		}
		
		System.out.println();
		
		for (d = 0; d < gameArray.length; d++) {
			
			System.out.print(" " + l++);
			
		}
		
		System.out.println();
				
	}
	
}
