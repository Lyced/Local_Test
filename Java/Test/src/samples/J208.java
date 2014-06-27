package samples;

public class J208 {

	public static void main(String[] args) {
		
		//program to estimate the value of Pi by 4 * (1 - 1/3 + 1/5 - 1/7 + 1/9 -...) up to 1/99
		
		double tempPi = 0, pi, count = 1;
		boolean negative = false;
		
		while (count < 100) {
			
			if (negative == true) {
				tempPi -= (1/count);
				negative = false;
			} else {
				tempPi += (1/count);
				negative = true;
			}
			
			count += 2;
			
		}
		
		pi = tempPi * 4;
		
		System.out.println("The value of Pi is estimated to be: " + pi + ".");

	}

}
