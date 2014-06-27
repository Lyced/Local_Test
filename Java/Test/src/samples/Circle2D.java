package samples;

import java.lang.Math;

//the Circle2D class and all its methods

public class Circle2D {

	double x, y, radius, area, perimeter;
	
	//constructor
	public Circle2D(double a, double b, double c) {
		
		x = a;
		y = b;
		radius = c;
		
	}
	
	//determines and returns the area of a circle
	public double getArea() {
		
		area = (Math.PI * (radius * radius));
		
		return area;

	}
	
	//determines and returns the perimeter of a circle
	public double getPerimeter() {
		
		perimeter = 2 * Math.PI * radius;
		
		return perimeter;
		
	}
	
	//method that determines whether a point lies within a circle
	public boolean contains(double x1, double y1) {
		
		double deltax, deltay;
		
		deltax = Math.abs(x1 - x);
		deltay = Math.abs(y1 - y);
		
		//if the distance between the provided point and the center of the circle is less than the radius
		//then it is in the circle
		if (Math.sqrt((deltax * deltax) + (deltay * deltay)) < radius) {
			
			return true;
		}
		
		return false;
		
	}
	
	//determines and returns whether a provided Circle2D object lies within another circle
	public boolean containsCircle(Circle2D t) {
		
		double deltax, deltay;
		
		deltax = Math.abs(t.x - x);
		deltay = Math.abs(t.y - y);
		
		//if the distance between the two centers and the radius of the smaller circle is smaller than
		//the radius of the bigger circle, then the smaller circle lies within the larger circle
		if ((Math.sqrt((deltax * deltax) + (deltay * deltay)) + t.radius) < radius) {
			
			return true;
		}
		
		return false;
	}
	
	//a static method that, provided two circle objects, determines whether they are disjointed
	public static boolean disjoint(Circle2D q, Circle2D w) {
		
		double deltax, deltay;
		
		deltax = Math.abs(q.x - w.x);
		deltay = Math.abs(q.y - w.y);
		
		//if the distance between the two centers is greater than the sum of the two radiuses, then
		//the two circles are disjointed 
		if (Math.sqrt((deltax * deltax) + (deltay * deltay)) > (q.radius + w.radius)) {
			
			return true;
		}
		
		return false;
	}
}
