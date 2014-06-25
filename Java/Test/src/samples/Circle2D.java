package samples;

import java.lang.Math;

public class Circle2D {

	double x, y, radius, area, perimeter;
	
	public Circle2D(double a, double b, double c) {
		
		x = a;
		y = b;
		radius = c;
		
	}
	
	public double getArea() {
		
		area = (Math.PI * (radius * radius));
		
		return area;

	}
	
	public double getPerimeter() {
		
		perimeter = 2 * Math.PI * radius;
		
		return perimeter;
		
	}
	
	public boolean contains(double x1, double y1) {
		
		double deltax, deltay;
		
		deltax = Math.abs(x1 - x);
		deltay = Math.abs(y1 - y);
		
		if (Math.sqrt((deltax * deltax) + (deltay * deltay)) < radius) {
			
			return true;
		}
		
		return false;
		
	}
	
	public boolean containsCircle(Circle2D t) {
		
		double deltax, deltay;
		
		deltax = Math.abs(t.x - x);
		deltay = Math.abs(t.y - y);
		
		if ((Math.sqrt((deltax * deltax) + (deltay * deltay)) + t.radius) < radius) {
			
			return true;
		}
		
		return false;
	}
	
	public static boolean disjoint(Circle2D q, Circle2D w) {
		
		double deltax, deltay;
		
		deltax = Math.abs(q.x - w.x);
		deltay = Math.abs(q.y - w.y);
		
		if (Math.sqrt((deltax * deltax) + (deltay * deltay)) > (q.radius + w.radius)) {
			
			return true;
		}
		
		return false;
	}
}
