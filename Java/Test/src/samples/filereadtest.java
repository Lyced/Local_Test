package samples;

import java.io.FileReader;
import java.io.File;
import java.util.Scanner;

public class filereadtest {

	public static void main (String []args) {
		
		int i;
		String fileLocation;
		Scanner input = new Scanner(System.in);
		File file = new File(fileLocation);
		FileReader filein = new FileReader(file);
		
		System.out.print("Please enter the filename location: ");
		fileLocation = input.nextLine();
		file.
		
		while (fileLocation != "End") {
			
			System.out.println(filein.read());
			
		}
		
	}
}
