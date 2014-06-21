package samples;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class filereadtest {

	/*
	public static void main (String []args) throws IOException {
		
	//	int i;
		String filecontent;
		Scanner input = new Scanner(System.in);
	//	File file = new File(fileLocation);
	//	FileReader filein = null;
		BufferedReader BReader = null;
		Path filepath = Paths.get("D:\\Dropbox\\BankData.txt");
		
		try {
			
			//filein = new FileReader(filepath);
			BReader = Files.newBufferedReader(filepath);			
		
	//	System.out.print("Please enter the filename location: ");
	//	fileLocation = input.nextLine();
	//	filein.read();
		
			while ((filecontent = BReader.readLine()) != null) {
				
				System.out.println(filecontent);
				
			}
		} finally {
			
			if (BReader != null) {
				BReader.close();
			}
			
		}
	}
	*/
	public static void main (String []args) throws IOException {
		
		double temp;
		String Location;
		Scanner input = null;
		Path filepath = Paths.get("D:\\Dropbox\\BankData.txt");
		
		try {
			Location = filepath.toString();
			input = new Scanner(new BufferedReader (new FileReader (Location)));
			
			while (input.hasNext()) {
				
				temp = input.nextDouble();
				System.out.println(temp);
			}
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}
}
