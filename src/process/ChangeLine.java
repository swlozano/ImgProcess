package process;

//Java program to demonstrate colored to greyscale conversion 
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ChangeLine {
	public static void main(String args[]) throws IOException {
		BufferedImage img1 = null;

		File file = null;

		// read image
		try {
			file = new File(Data.IN1);
			img1 = ImageIO.read(file);
		} catch (IOException e) {
			System.out.println(e);
		}

		// get image's width and height
		int width = img1.getWidth();
		int height = img1.getHeight();
		int p = 0;

		// convert to greyscale
		for (int y = 0; y < height; y=y+2) {
			for (int x = 0; x < width; x++) {

				
				if (y + 2 < height) {
					p = img1.getRGB(x, y);
					img1.setRGB(x, y + 2, p);

					p = img1.getRGB(x, y + 2);
					img1.setRGB(x, y, p);
				}


			}
		}

		// write image
		try {
			file = new File(Data.OUT);
			ImageIO.write(img1, "png", file);
			System.out.println("end change Line");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
