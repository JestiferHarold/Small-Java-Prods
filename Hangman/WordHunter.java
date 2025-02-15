import java.util.ArrayList;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class WordHunter {

//	private final Scanner hunter;
	private final Random finder = new Random();
	private static int wordLine;

	private int getRandomNumber() {
		return this.finder.nextInt(466550);
	}

	public String getWord() {
		wordLine = this.getRandomNumber(); 	
		int i = 1;
		wordLine = 10;
		String line;
		try {
			BufferedReader getter = new BufferedReader(new FileReader ("words.txt"));
			while ((line = getter.readLine()) != null) {
				if (i == (wordLine)) {
					return line;
				}
				i ++;
			}
		} catch (IOException e) {

			System.out.println("Input Output error");
		}

		return "1";
	}
}
					

