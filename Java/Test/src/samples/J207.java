package samples;

import java.util.Scanner;
import java.util.Stack;
import java.lang.Math;

public class J207 {

	public static void main(String[] args) {
		
		//program calculates the standard deviation of a list of values entered by the user
		
		double num = 0;
		Stack<Double> temp = new Stack<Double>(); //using a stack since the user can enter as many values as they please
		Scanner input = new Scanner(System.in);
					
		while (num != -9999) { //using -9999 as the terminal value for convenience
			System.out.print("Please enter a number (-9999 to stop): ");
			num = input.nextDouble();			
				
			if (num != -9999) {
				//as long at the value entered is not the terminal value, push it into the stack	
				temp.push(num);
				
			}
		}
			
		//once all the values have been entered, pass the stack to the standard_dev method to find
		//the standard deviation
		System.out.println("The standard deviation is " + standard_dev(temp)+ ".");
		input.close();

	}

	
	public static double standard_dev(Stack<Double> temp) {
		
		double average, total, sumSquares, poppedValue;
		int size;
		
		size = temp.size(); //determining the number of values in the stack
		sumSquares = total = 0;
		
		while(!temp.empty()) { // while the stack is not empty...
			
			poppedValue = temp.pop();
			total += poppedValue; //pop the value and add it to the total
			sumSquares += (poppedValue * poppedValue); //use the popped value to determine the sum of squares
			
		}
		
		average = total/size; //determining the average value of the list
		
		return (Math.sqrt((sumSquares/size)-(average*average))); //returning the standard deviation
		
	}
}
