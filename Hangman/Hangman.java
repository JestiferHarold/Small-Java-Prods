import java.util.Scanner;

public class Hangman {
	private int lifes = 4;
	public Scanner lifeSaver = new Scanner(System.in);

	public static void main(String[] args) {
		WordHunter hansLanda = new WordHunter();
		
		char[] toBeHeld = hansLanda.getWord().toCharArray();
		int length = toBeHeld.length;
		
		while (true) {
			System.out.println("Enter the word");

	}
}

