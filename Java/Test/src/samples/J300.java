package samples;

import java.util.Scanner;
import java.lang.Math;
import java.io.IOException;

public class J300 {

	//program that simulates a game of memory
	
	public static void main(String[] args) {
		
		int size;
		char YN;
		char[] gameArray; //array that stores the "face" value
		boolean[] flipped; //array that mirrors and stores which values have been matches in the gameArray
		Scanner input = new Scanner(System.in);
		
		for (;;) {
			
			System.out.print("Please enter the size of the game (even integer between 2 and 52): ");
			size = input.nextInt(); //gets the game size from the user
			
			while (!validate_size(size)){ 
				
				//passes the value to be validated as whether it is indeed an even integer
				//that is between 2 and 52
				size = input.nextInt();
				
			}
			
			//create the game arrays with the provided size
			gameArray = new char[size];
			flipped = new boolean[size];
			
			create_array(gameArray, flipped); //sets up the game
	
			play_game(input, gameArray, flipped); //play the game
			
			System.out.print("Would you like to play another? Y/N: ");
			YN = input.next().charAt(0); //at the end, checks if you want to play another
			
			if (YN == 'N' || YN == 'n') {
				//if no, exit out of the game loop
				break;
				
			}
		}
		
		input.close();
	}
	
	public static boolean validate_size(int size) {
		
		//method that checks is the user determined game size is valid
		
		if (size < 2 || size > 52) { //is it with the range of game sizes?
			
			System.out.println("Value entered is not valid.");
			return false;
			
		} else if ((size%2) != 0) { //is it an even integer?
			
			System.out.println("The number entered is not an even number.");
			return false;
			
		} else { 
		
			//if passes the two tests, return true
			return true;
			
		}
	}
	
	public static void create_array(char[] gameArray, boolean[] flipped) {
		
		int i, t = 0;
				
		for (i = 0; i <gameArray.length; i++) {
			
			//capital letters are used as the "face" values to be matched
			//the program first assigns two blocks in the array with the same letter
			
			gameArray[i] = (char)((int)('A') + t);
			gameArray[++i] = (char)((int)('A') + t);
			t++;
			
		}
		
		for (i = 0; i < flipped.length; i++) {
		
			//initializing the cells in the mirrored array to false since it's the beginning of the game
			flipped[i] = false;
			
		}
		
		//once that's done, shuffle gameArray so the face values are in different locations
		shuffle_array(gameArray);	
		
	}

	public static void shuffle_array(char[] gameArray) {
		
		int s, swap1, swap2;
		char holding;
		
		//for 1000 iterations (could be more), randomly pick two cell locations via RNG
		//in gameArray and swap the values
		for (s = 0; s != 1000; s++) {
			
			swap1 = (int)(gameArray.length * Math.random());
			swap2 = (int)(gameArray.length * Math.random());
			
			if (swap1 != swap2) {
				
				//if the swap locations are not the same, do the actual swap, otherwise skip this
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

			//draws the visual output of the game for the user
			drawOutput(gameArray, flipped);
			
			System.out.print("Please enter which two boxes you would like to flip: ");
			pair1 = input.nextInt();
			pair2 = input.nextInt(); //gets the two locations that the user wants to flip
			
			if ((pair1 - 1) < 0 || (pair2 - 1) < 0 || (pair1 - 1) > gameArray.length || (pair2 - 1) > gameArray.length) {
			
				//simple check to see if the values entered are valid
				System.out.println("The values entered are outside the valid range.");
				
			} else if (flipped[pair1 - 1] == true || flipped[pair2 - 1] == true) {
				
				//simple check to see if the locations are already flipped
				System.out.println("Values entered are already used.");
				
			} else {
				
				//if valid values are entered, reveal the face values are the locations chosen
				if (check_pairing(pair1, pair2, gameArray)){ //call method check_pairing to see if the values match
					
					//if they match, flag those locations as flipped and increment the number of
					//cells flipped by 2
					flipped[pair1 - 1] = true;
					flipped[pair2 - 1] = true;
					boxesFlipped += 2; 
					
				}
				
				if (boxesFlipped == gameArray.length) {
					
					//if the number of boxes flipped is equal to the number of cells in gameArray
					//the game is finished and flag it as so to exit of the play_game method
					gameFinished = true;
					
				} else {
					
					//if the game is still in progress, show the user the face values of the two
					//locations that they chose
					showOutput(pair1, pair2, gameArray, flipped);
					
				}
				
				attempts++; //keep track of the number of attempts made
			}
		}
		
		//once finished, show the user the completed array and the play statistics
		drawOutput(gameArray, flipped);
		System.out.println("Game finished with " + attempts + " attempts.");
		System.out.println("That is " + (attempts - (gameArray.length)/2) + " more than the best possible result.");
		
	}
	
	public static boolean check_pairing(int pair1, int pair2, char[] gameArray) {
		
		//simple check to see if the face values of the two locations selected by the user match
		if (gameArray[pair1 - 1] == gameArray[pair2 - 1]) {
			
			return true;
			
		} else {
			
			return false;
			
		}
	}
	
	public static void showOutput(int pair1, int pair2, char[] gameArray, boolean[] flipped) {
		
		int space, d, l = 1;
		
		//method called while the game is still in process
		for (d = 0; d < gameArray.length; d++) {
			
			if (d == (pair1 - 1) || d == (pair2 - 1)  || flipped[d]) {
				
				//show the face value of the cells selected by the user and those that have already been matched
				System.out.print(" " + gameArray[d] + " ");
				
			} else {
				
				//otherwise show a "*"
				System.out.print(" *");
				
			}
		}
		
		System.out.println();
		
		for (d = 0; d < gameArray.length; d++) {
			
			//labeling the location of gameArray
			System.out.print(" " + l++);
			
		}
				
		System.out.println();
		
		//pausing the application and waiting for user input before moving on
		System.out.println("Press enter to continue.");
		
		
		try {
			
			System.in.read();
			
		} catch (IOException e) {
		
			System.out.println("User read error.");
		
		}
		
		for (space = 0; space < 5; space ++) {
			
			//making whitespace to push the previous results out of view in the console
			System.out.println();
			
		}
		
	}
	
	public static void drawOutput(char[] gameArray, boolean[] flipped) {
		
		int d, l = 1;
	
		
		//displaying the current state of gameArray 
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
