import java.io.IOException;

import process.Grayscle;
import process.Read;

public class Main {
	


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("What-----");
		//Grayscle.main(args);
		//Read.pixel(args);
		int max = 500000;
		int min = 1;
		
		for (int i = 0; i < 500000; i++) {
			
			int random_int = (int)(Math.random() * (max - min + 1) + min);
			System.out.println("Random " + i  + ":" +  random_int);
		}
		
	}

}
