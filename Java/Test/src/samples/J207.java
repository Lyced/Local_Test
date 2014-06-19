package samples;

import java.util.Scanner;
import java.util.Stack;
import java.lang.Math;

public class J207 {

	public static void main(String[] args) {
		
		double num = 0;
		Stack<Double> temp = new Stack<Double>();
		Scanner input = new Scanner(System.in);
		
	//	for (;;) {
			
			while (num != -9999) {
				System.out.print("Please enter a number (-9999 to stop): ");
				num = input.nextDouble();			
				
				if (num != -9999) {
					
					temp.push(num);
				}
			}
			
			System.out.println("The standard deviation is " + standard_dev(temp)+ ".");
			input.close();
	//	}
	}

	
	public static double standard_dev(Stack<Double> temp) {
		
		double average, total, sumSquares, poppedValue;
		int size;
		
		size = temp.size();
		sumSquares = total = 0;
		
		while(!temp.empty()) {
			
			poppedValue = temp.pop();
			total += poppedValue;
			sumSquares += (poppedValue * poppedValue);
			
		}
		
		average = total/size;
		
		return (Math.sqrt((sumSquares/size)-(average*average)));
		
	}
}
