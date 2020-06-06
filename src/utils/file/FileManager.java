package utils.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {

	public String read(String filePath) {
		File file = new File(filePath);
		String st;
		String st1 = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((st = br.readLine()) != null) {
				st1 += st;
				st1 += "\n";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st1;

	}

	public BufferedReader read_(String filePath) {
		File file = new File(filePath);
		String st;
		String st1 = "";
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			return br;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void writeFile(String filePath) {
		String str = "->World<-";
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(filePath, true));
			// writer.append(' ');
			// writer.append(str);

			writer.write(str);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void write(String filePath) {
		String str = "Hello";
		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(filePath);
			byte[] strToBytes = str.getBytes();
			outputStream.write(strToBytes);
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void write2(String filePath, String strToWrite) throws IOException {
		

		strToWrite+="\n";
		Path path = Paths.get(filePath);
		byte[] strToBytes = strToWrite.getBytes();

		Files.write(path, strToBytes);

		String read = Files.readAllLines(path).get(0);
		//System.out.println(read);
		//assertEquals(str, read);
	}

}
