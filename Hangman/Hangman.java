import java.util.Scanner;
import java.util.Arrays;
// import java.util.ArrayList;

public class Hangman {
	private int lifes = 4;
	public Scanner lifeSaver = new Scanner(System.in);

	public void Verdict() {
		if (this.lifes == 0 || this.lifes < 0) {
			System.out.println("Wrong guess The Player is dead");
		}
	}

	public int getIndex(char[] array, boolean[] array2, char target) {
		int f = -1;
		for(int i = 0; i < array.length; ++i) {
			if ((String.valueOf(array[i]).equals(String.valueOf(target))) && (array2[i] == false)) {
				array2[i] = true;
				f = 1;
			}
		}
		return f;
	}

	public boolean didHeWin(boolean[] bools) {
		for (boolean bool : bools) {
			if (!bool) {
				return false;
			}
		}
		return true;
	}

	// public ArrayList<Integer> getIndex(char[] array, char target, )
	
	// public void 

//	public int get

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

		HangDiagram potrait = HangDiagram.FULL_LIFE;	

		while (potrait != HangDiagram.DEAD) {
			System.out.println(potrait.getDiagram());
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
	int index = woman.getIndex(toBeHeld, bool, input);
			if (index > -1) {
				
				if (index == 1) {
					// bool[index] = true;
					if (woman.didHeWin(bool)) {
						System.out.println("You've Won The Game");
						System.out.println("The word is " + String.valueOf(toBeHeld));
						System.exit(0);
					}
					System.out.println("Entered word is available");
					continue;
				}
				System.out.println("The word is already present you've lost one life");
				continue;
			}
			System.out.println("Wrong guess You've lost 1 life");
			--woman.lifes;	
			switch (woman.lifes) {
				case 3:
					potrait = HangDiagram.THREE_LIFES;
					break;
				case 2:
					potrait = HangDiagram.TWO_LIFES;
					break;
				case 1:
					potrait = HangDiagram.ONE_LIFE;
					break;
				default:
					potrait = HangDiagram.DEAD;
			}
		}
		System.out.println(potrait.getDiagram());
		System.out.println("The word is " + String.valueOf(toBeHeld));
	}
}

