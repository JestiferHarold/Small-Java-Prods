import java.util.Scanner;
import java.util.Arrays;

public class Hangman {
	private int lifes = 4;
	public Scanner lifeSaver = new Scanner(System.in);

	public void Verdict() {
		if (this.lifes == 0 || this.lifes < 0) {
			System.out.println("Wrong guess The Player is dead");
		}
	}

	public int getIndex(char[] array, char target) {
		for(int i = 0; i < array.length; i++) {
			if (array[i] == (target)) {
				return i;
			}
		}
		return -1;
	}

//	public String wordRecreation() /{


	public static void main(String[] args) {
		WordHunter hansLanda = new WordHunter();
		Hangman woman = new Hangman();
	
		char[] toBeHeld = hansLanda.getWord().toCharArray();
		int length = toBeHeld.length;
		boolean[] bool = new boolean[length];
		System.out.println(bool.length + "  " + length);
		System.out.println("To start the game enter 1,\nto quit enter 2 and \nto get the docs enter 3");	
		switch (woman.lifeSaver.nextInt()) {
			case 1:
				break;
			case 2:
				System.exit(0);
			case 3:
				break;
			default:
				System.out.println("Wrong option");
				System.exit(1);
		}

		while (woman.lifes > 0 && woman.lifes < 5) {
			System.out.println("Enter the word");
			for (int i = 0; i < length ; i++) {
				if (bool[i]) {
					System.out.print(toBeHeld[i] + " ");
					continue;
				}
				System.out.print("_ ");
			}
			System.out.println("\nEnter the worde");
			//woman.lifeSaver.nextLine();
			char input = woman.lifeSaver.next().charAt(0); 
//			if (Arrays.asList(toBeHeld).contains(input)) {
			if (Arrays.binarySearch(toBeHeld, input) > -1) {
				int index = woman.getIndex(toBeHeld, input);
				if (!bool[index]) {
					bool[index] = true;
					System.out.println("Entered word is available");
					continue;
				}
				System.out.println("The word is already present you've lost one life");
				continue;
			}
			System.out.println("Wrong guess You've lost 1 life");
			--woman.lifes;	
		}
		System.out.println("The word is " + String.valueOf(toBeHeld));
	}
}

