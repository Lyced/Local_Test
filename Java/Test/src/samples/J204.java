package samples;

import java.util.Scanner;

public class J204 {

	public static void main(String[] arg) {
		
		//this program determines whether user inputted horizontal and vertical line intersect in the x-y plane
		
		double Hy, Hxl, Hxr, Vx, Vyt, Vyb;
		boolean validVertical = false;
		Scanner input = new Scanner(System.in);
		
		for (;;){
			
			System.out.print("Please enter the horizontal segment's coordinates (y-value, left x-value, right x-value or 0 0 0 to exit): ");
			Hy = input.nextDouble();
			Hxl = input.nextDouble();
			Hxr = input.nextDouble();
			
			if (Hy == 0 && Hxl == 0 && Hxr == 0) {
				//terminal values
				break;
				
			} else if (Hxl > Hxr) {
				//enforcing that the left and right values are entered in the correct order
				System.out.println("The horizontal values entered are not valid.");
				
			} else {
			
				//if the horizontal values are valid, then get the vertical values
				
				while (!validVertical) {
					
					System.out.print("Please enter the vertical segment's coordinates (x-value, bottom y-value, top y-value: ");
					Vx = input.nextDouble();
					Vyb = input.nextDouble();
					Vyt = input.nextDouble();
					
					if (Vyb > Vyt) {
						//similar to the horizontal values, if the vertical values are not entered in
						//in the correct order, throw an error message
						System.out.println("The vertical values entered are not valid.");
						
					} else {
						
						//if the vertical values are valid, pass the values to the check_intersect method
						//and flag the boolean as true to loop back to the beginning of the program 
						validVertical = true;
						check_intersect(Hy, Hxl, Hxr, Vx, Vyt, Vyb);
						
					}
				}
			}
			
			validVertical = false; //at the end, reset the boolean as false
		}	
		
		input.close();
	}
	
	public static void check_intersect(double Hy, double Hxl, double Hxr, double Vx, double Vyt, double Vyb) {
		
		if (Hy < Vyt && Hy > Vyb && Vx > Hxl && Vx < Hxr) {
			//if the y-value of the horizontal component is within the range of the y-values of the vertical
			//component and the x-values of the vertical component is within the range of the x-values of
			//the horizontal component, then the two segments/lines intersect
			System.out.println("The vertical and horizontal segments intersect.");
			
		} else {
			//if not, then they don't
			System.out.println("The vertical and horizontal segments do not intersect.");
			
		}
		
	}
}
