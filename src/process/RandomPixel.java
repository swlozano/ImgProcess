package process;

//Java program to demonstrate colored to greyscale conversion 
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import utils.SuperRandom;

public class RandomPixel {

	static SuperRandom superRandom;
	BufferedImage img1 = null;
	BufferedImage img2 = null;

	public static void main(String args[]) throws IOException {
		RandomPixel randomPixel = new RandomPixel();
		randomPixel.process();

	}

	public void process() throws IOException {
		
		readFile();
		int p = 0;
		superRandom = new SuperRandom(img1.getHeight(), img1.getWidth());

		for (int y = 0; y < img1.getHeight(); y = y + 1) {
			for (int x = 0; x < img1.getWidth(); x++) {

				try {
					int randomNumber = superRandom.generateRandomNumber();
					int[] arrPos = getMatrixPosition(randomNumber - 1, img1.getHeight());
					if (randomNumber % 2 == 0)
						// if (true)
						p = img1.getRGB(arrPos[0], arrPos[0]);
					else
						p = img2.getRGB(arrPos[0], arrPos[0]);

				} catch (Exception e) {
					System.out.println("Error 1");
				}

				try {
					img1.setRGB(x, y, p);
				} catch (Exception e) {
					System.out.println("Error 2" + e.getMessage());
				}

			}
		}		
		writeImage(img1);
	}
	
	
	private void readFile() {
		File file = null;

		// read image
		try {
			file = new File(Data.IN1);
			img1 = ImageIO.read(file);

			file = new File(Data.IN2);
			img2 = ImageIO.read(file);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
	private static void writeImage(BufferedImage img) {
		try {
			Calendar calendar = Calendar.getInstance();
			File file = new File(Data.OUT + "out_" + calendar.getTimeInMillis() + ".png");
			ImageIO.write(img, "png", file);
			System.out.println("end Random Pixel");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public int[] getMatrixPosition(int randomNumber, int numCols) {
		int row = randomNumber / numCols;
		int firstPosition = row * numCols;
		int col = randomNumber - firstPosition;
		int vals[] = { row, col };
		System.out.println("pos: " + row + "," + col);
		return vals;
	}

}
