package samples;

import samples.Circle2D;

public class Circle2DTest {

	public static void main(String[] args) {
		
		Circle2D C1, C2, C3;

		C1 = new Circle2D(2, 2, 5.5);
		C2 = new Circle2D(4, 5, 10.5);
		C3 = new Circle2D(10, 20, 2.3);
		
		System.out.println("The area of circle C1 is " + C1.getArea() + ".");
		System.out.println("The perimeter of circle C1 is " + C1.getPerimeter() + ".");
		
		if (C1.contains(3, 3)) {
			
			System.out.println("Point 3 ,3 is in the circle.");
			
		}
		
		if (C1.containsCircle(C2)) {
			
			System.out.println("The circle C2 is in C1.");
			
		}
		
		
		if (Circle2D.disjoint(C1,C3)){
			
			System.out.println("The circle C1 and C3 are disjointed.");
			
		}
		
	}

}
