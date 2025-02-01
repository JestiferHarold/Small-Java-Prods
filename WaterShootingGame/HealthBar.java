import java.util.Scanner;
import java.util.Random;
//import jline.console.ConsoleReader;

public class HealthBar{

	private int HP;
	private Random randomiser;

	private boolean isPlayerDead(){
		if (this.HP <= 0) {
			return true;
		} 
		return false;
	}

//	@Getter
	public int getHP() {
		return this.HP;
	}
	
//	@Setter
	public void damageInflicted(int damage, WaterGun self) {
		this.HP -= damage;
	//	self.attackSuccessful(damage);
	}

//	@Setter
	public void healDamage() {
		java.util.function.Supplier<Integer> heal = () -> {
			int rand = randomiser.nextInt(20);
			if (this.HP + rand > 100) {
				return 100 - this.HP;
			}
			return rand;
		};
//		this.HP += heal;
	}

//256 for white	
//	public void printHealthBar() {
//		terminalWidth = jline.TerminalFactory.get().getWidth();
//		System.out.println(terminalWidth);
//	}


	public static void printHealthBar(HealthBar player1, HealthBar player2) {
		HealthBar[] baring = {player1, player2};

		for (HealthBar i : baring) {
			System.out.print("[");
			int f = i.getHP() / 2;
			for (int j = 0; j < f; j++) {
				System.out.print("#");
			}
			for (int k = 0; k < 50 - f; k++) {
				System.out.print("-");
			}
			System.out.println("]");
		}
	}


	public HealthBar() {
		this.HP = 50;
		randomiser = new Random();
	}

//	public static void main(String[] args) {
//		HealthBar bar = new HealthBar(); 
	//	bar.printHealthBar();
//	}

	public static void main(String[] args){ 
		HealthBar p1 = new HealthBar();
		HealthBar p2 = new HealthBar();
		p2.HP = 0;
		printHealthBar(p1, p2);	
	}
}


