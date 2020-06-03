package process;

//Java program to demonstrate colored to greyscale conversion 
import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 

public class Grayscle 
{ 
	public static void main(String args[])throws IOException 
	{ 
		BufferedImage img = null; 
		File file = null; 

		// read image 
		try
		{ 
			file = new File(Data.IN1); 
			img = ImageIO.read(file); 
		} 
		catch(IOException e) 
		{ 
			System.out.println(e); 
		} 

		// get image's width and height 
		int width = img.getWidth(); 
		int height = img.getHeight(); 

		// convert to greyscale 
		for (int y = 0; y < height; y++) 
		{ 
			for (int x = 0; x < width; x++) 
			{ 
				// Here (x,y)denotes the coordinate of image 
				// for modifying the pixel value. 
				int p = img.getRGB(x,y); 

				int a = (p>>24)&0xff; 
				int r = (p>>16)&0xff; 
				int g = (p>>8)&0xff; 
				int b = p&0xff; 

				// calculate average 
				int avg = (r+g+b)/3; 

				// replace RGB value with avg 
				p = (a<<24) | (avg<<16) | (avg<<8) | avg; 

				//System.out.println(img.getRGB(x, y));
				img.setRGB(x, y, p); 
				//img.set
			} 
		} 

		// write image 
		try
		{ 
			file = new File(Data.OUT); 
			ImageIO.write(img, "png", file); 
			System.out.println("end");
		} 
		catch(IOException e) 
		{ 
			System.out.println(e); 
		} 
	} 
} 
