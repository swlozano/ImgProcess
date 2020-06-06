import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import process.Grayscle;
import process.Read;
import utils.SuperRandom;
import utils.file.FileManager;

public class Main implements Runnable {

	public static void main1(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("What-----");
		// Grayscle.main(args);
		// Read.pixel(args);
		int max = 500000;
		int min = 1;

		/*
		 * for (int i = 0; i < 500000; i++) {
		 * 
		 * int random_int = (int)(Math.random() * (max - min + 1) + min);
		 * System.out.println("Random " + i + ":" + random_int); }
		 */
		createWindow();

	}

	private static void createWindow() {
		System.out.print("What-----");
		// Create and set up the window.
		JFrame frame = new JFrame("Simple GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel textLabel = new JLabel("I'm a label in the window", SwingConstants.CENTER);
		textLabel.setPreferredSize(new Dimension(500, 500));
		frame.getContentPane().add(textLabel, BorderLayout.CENTER);
		// Display the window.
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}

	public static void canvas(String[] args) {
		final String title = "Test Window";
		final int width = 1280 * 2;
		final int height = 800 * 2;

		// Creating the frame.
		JFrame frame = new JFrame(title);

		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		// Creating the canvas.
		Canvas canvas = new Canvas();

		canvas.setSize(width, height);
		canvas.setBackground(Color.BLACK);
		canvas.setVisible(true);
		canvas.setFocusable(false);

		// Putting it all together.
		frame.add(canvas);

		canvas.createBufferStrategy(3);

		boolean running = true;

		BufferStrategy bufferStrategy;
		Graphics graphics;

		while (running) {
			bufferStrategy = canvas.getBufferStrategy();
			graphics = bufferStrategy.getDrawGraphics();
			graphics.clearRect(0, 0, width, height);
			graphics.setColor(Color.GREEN);

			FileManager fileManager = new FileManager();
			BufferedReader br = fileManager.read_("/Users/dev/Downloads/banner.txt");
			String st;
			int y = 0;
			int x = 0;
			try {
				while ((st = br.readLine()) != null) {
					x = 0;
					for (int i = 50; i < st.length(); i++) {
						graphics.drawString(st.charAt(i) + "", x, y);
						x += 10;
						// System.out.println("lenght "+st.toCharArray().length);
						// graphics.drawChars(st.toCharArray(), 100, st.toCharArray().length-100, x, y);
						// x+=10;
					}
					y += 10;

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			bufferStrategy.show();
			graphics.dispose();
		}
	}

	public static void main(String[] args) throws Exception {
		// We need to provide file path as the parameter:
		// double backquote is to avoid compiler interpret words
		// like \test as \t (ie. as a escape sequence)

		// while ((st = br.readLine()) != null)
		// System.out.println(st);

		/*
		 * Thread t = new Thread(new Runnable() { File file = new
		 * File("/Users/dev/Downloads/banner.txt"); BufferedReader br = new
		 * BufferedReader(new FileReader(file)); String st;
		 * 
		 * @Override public void run() {
		 * 
		 * try {
		 * 
		 * while ((st = br.readLine()) != null) {
		 * 
		 * for (int i = 0; i < st.length(); i++) {
		 * 
		 * System.out.print(st.charAt(i)); try { Thread.sleep(0, 1); } catch
		 * (InterruptedException e) { e.printStackTrace(); } } System.out.println(); } }
		 * catch (IOException e) { e.printStackTrace(); }
		 * 
		 * } }); t.start();
		 */

		// System.out.print("---------");
		// System.out.close();
		// canvas(null);
		FileManager fileManager = new FileManager();

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {

					for (int i = 0; i <= 100; i++) {
						Thread.sleep(500);
						fileManager.write2("/Users/dev/eclipse-workspace/ImgProcess/out/banner.txt", "count\n" + i);
					}

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		t.start();

	}

	@Override
	public void run() {

	}

}
