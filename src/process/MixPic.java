package process;

//Java program to demonstrate colored to greyscale conversion 
import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 

public class MixPic 
{ 
	public static void main(String args[])throws IOException 
	{ 
		BufferedImage img1 = null;
		BufferedImage img2 = null;
		
		File file = null; 

		// read image 
		try
		{ 
			file = new File(Data.IN1); 
			img1 = ImageIO.read(file); 
			file = new File(Data.IN2);
			img2 = ImageIO.read(file);
		} 
		catch(IOException e) 
		{ 
			System.out.println(e); 
		} 

		// get image's width and height 
		int width = img1.getWidth(); 
		int height = img1.getHeight(); 

		// convert to greyscale 
		for (int y = 0; y < height; y++) 
		{ 
			for (int x = 0; x < width; x++) 
			{ 
				// Here (x,y)denotes the coordinate of image 
				// for modifying the pixel value.
				int p = img1.getRGB(x,y);
				if(x%2==0)
					p = img1.getRGB(x,y);
				else
					p = img2.getRGB(x,y);
				

				//System.out.println(img.getRGB(x, y));
				img1.setRGB(x, y, p); 
				//img.set
			} 
		} 

		// write image 
		try
		{ 
			file = new File(Data.OUT); 
			ImageIO.write(img1, "png", file); 
			System.out.println("end mix");
		} 
		catch(IOException e) 
		{ 
			System.out.println(e); 
		} 
	} 
} 
