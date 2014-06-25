package samples;

import java.util.Scanner;

public class J502 {

	//This program counts the number of times a user specified letter appears in the word that the user supplies
	
	public static void main(String[] args) {
		
		String str;
		char a;
		Scanner input = new Scanner (System.in);
		
		for (;;) {
			
			System.out.print("Please enter the source word: ");
			str = input.next().toLowerCase();
			
			if (str.equals("exit")) {
				
				break;
				
			}
											
			System.out.print("Please enter the letter that you wish to count: ");
			a = input.next().charAt(0);
			
			System.out.println("The letter " + a + " appears in the word " + str + " " + count(str,a) + " times.");
			
		}
		
		input.close();

	}
	
	public static int count(String str, char a) {
		
		int i, count = 0;
		
		for (i = 0; i < str.length(); i ++) {
			
			if (str.charAt(i) == a) {
				
				count++;
				
			}
			
		}
		
		return count;
		
	}

}
