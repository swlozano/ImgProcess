import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import process.Grayscle;
import process.Read;
import utils.SuperRandom;

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

	public static void main2(String[] args) {
		final String title = "Test Window";
		final int width = 1280;
		final int height = 800;

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

			graphics.drawString("This is some text placed in the top left corner.", 0, 15);

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

		Thread t = new Thread(new Runnable() {
			File file = new File("/Users/dev/Downloads/banner_.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));

			String st;

			@Override
			public void run() {

				try {

					while ((st = br.readLine()) != null) {

						for (int i = 0; i < st.length(); i++) {

							if (st.charAt(i) == ":".charAt(0))
								System.out.print("$".charAt(0));
							else
								System.out.print(st.charAt(i));
							try {
								Thread.sleep(0, 1);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						// System.out.println(st);
						System.out.println();

					}
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
		System.out.println("------------------$$$$$$$$$$$$$$$$$$$$$$$$$$$$$------------------->");
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
