package samples;

import java.util.Scanner;

public class J204 {

	public static void main(String[] arg) {
		
		double Hy, Hxl, Hxr, Vx, Vyt, Vyb;
		boolean validVertical = false;
		Scanner input = new Scanner(System.in);
		
		for (;;){
			
			System.out.print("Please enter the horizontal segment's coordinates (0 0 0 to exit): ");
			Hy = input.nextDouble();
			Hxl = input.nextDouble();
			Hxr = input.nextDouble();
			
			if (Hy == 0 && Hxl == 0 && Hxr == 0) {
				
				break;
				
			} else if (Hxl > Hxr) {
				
				System.out.println("The horizontal values entered are not valid.");
				
			} else {
			
				//System.out.println("The inputed values are " + Hy + ", " + Hxl + ", " + Hxr + ".");
				
				while (!validVertical) {
					
					System.out.print("Please enter the vertical segment's coordinates: ");
					Vx = input.nextDouble();
					Vyb = input.nextDouble();
					Vyt = input.nextDouble();
					
					if (Vyb > Vyt) {
						
						System.out.println("The vertical values entered are not valid.");
						
					} else {
						
				//		System.out.println("The inputed values are " + Vx + ", " + Vyb + ", " + Vyt + ".");
						validVertical = true;
						check_intersect(Hy, Hxl, Hxr, Vx, Vyt, Vyb);
						
					}
				}
			}
			
			validVertical = false;
		}	
		
		input.close();
	}
	
	public static void check_intersect(double Hy, double Hxl, double Hxr, double Vx, double Vyt, double Vyb) {
		
		if (Hy < Vyt && Hy > Vyb && Vx > Hxl && Vx < Hxr) {
			
			System.out.println("The vertical and horizontal segments intersect.");
			
		} else {
			
			System.out.println("The vertical and horizontal segments do not intersect.");
			
		}
		
	}
}
