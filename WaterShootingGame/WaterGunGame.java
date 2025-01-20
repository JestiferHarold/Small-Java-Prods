import java.util.Scanner;
import java.util.Random;

class HealthBar{

	/* To - Do
	 * getter and setter annotations
	 * Make the program work
	 *
	 */

	private String name;
	private int HP;
	private Random randomiser;

	public boolean ifDead(HealthBar p1, HealthBar p2, WaterGunGame game) throws InterruptedException{
		HealthBar[] array2 = {p1, p2};
		for(HealthBar i : array2) {
			java.util.function.BooleanSupplier f = () -> {
				if (i.getHP() <= -1){
					return (boolean)true;
				}
				return (boolean)false;
			};

			if (f.getAsBoolean()) {
				game.clearScreen();
				game.printslow(i.getName() + " has lost the match");
				return false;
			}
		}
		return true;
	}
//	@Getter
	public int getHP() {
		return this.HP;
	}

//	@Setter
	public String getName() {
		return this.name;
	}	

//	@Setter
	public void damageInflicted(int damage, WaterGun self) {
		this.HP -= damage;
		self.attackSuccessful(damage);
	}

//	@Setter
	public void healDamage() {
		java.util.function.IntSupplier heal = () -> {
			int rand = randomiser.nextInt(20);
			if (this.HP + rand > 100) {
				return (int)100 - this.HP;
			}
			return (int)rand;
		};
		this.HP += heal.getAsInt();
	}

//256 for white	
//	public void printHealthBar() {
//		terminalWidth = jline.TerminalFactory.get().getWidth();
//		System.out.println(terminalWidth);
//	}


	public void printHealthBar(HealthBar player1, HealthBar player2) {
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
			System.out.println("]" + " -> " + i.getName());
			System.out.println("");
		}
	}


	public HealthBar(String name) {
		this.HP = 100;
		randomiser = new Random();
		this.name = name;
	}

//	public static void main(String[] args) {
//		HealthBar bar = new HealthBar(); 
//		bar.printHealthBar();
//	}

//	public static void main(String[] args){ 
//		HealthBar p1 = new HealthBar();
//		HealthBar p2 = new HealthBar();
//		printHealthBar(p1, p2);	
//	}
}

class WaterGun{
	private int gunPower;
	private Random randomiser;

	public boolean missedAttack(){
		return randomiser.nextBoolean() && randomiser.nextBoolean() || randomiser.nextBoolean() && randomiser.nextBoolean();
	}

	public void fillGun(WaterGun waffer) {
		this.gunPower += this.randomiser.nextInt(1, 21);
	}

	public void attackSuccessful(int damage) {
		this.gunPower -=  damage;
	}

	
	public int attack(HealthBar Health, WaterGun gun ) {
		int damage = randomiser.nextInt(1, this.gunPower);
		Health.damageInflicted(randomiser.nextInt(1, damage), gun);
		return damage;
	}

	public int getGunPower() {
		return this.gunPower;
	}

	public WaterGun() {
		this.gunPower = 0;
		this.randomiser = new Random();
	}
}

public class WaterGunGame{

	public void printslow(String s) throws InterruptedException {
		char[] sa = s.toCharArray();
		//for(int i = 0; i < s.length; i++) {
		//	System.out.print(s.charAt(i));
		//	Thread.sleep(100);
		//}
		
		for(char i : sa) {
			System.out.print(i);
			Thread.sleep(50);
		}
		System.out.println("");
	}

	public void clearScreen() {

		System.out.print("\033\143");
	}

	public static void main(String[] args) throws InterruptedException{

		Random randomiser = new Random();
		Scanner prompt = new Scanner(System.in);
		WaterGunGame gun = new WaterGunGame();

		gun.clearScreen();
		gun.printslow("WELCOME TO WATER GUN GAME");
		gun.printslow("Enter the name of the first player : ");
		String firstPlayer = prompt.nextLine();
		gun.printslow("Enter the name of the second player : ");

		String secondPlayer = prompt.nextLine();
		gun.clearScreen();
		Thread.sleep(500);
		
		HealthBar p1 = new HealthBar(firstPlayer);
		HealthBar p2 = new HealthBar(secondPlayer);
		
		WaterGun g1 = new WaterGun();
		WaterGun g2 = new WaterGun();

		boolean isPlayer1Turn = true;

		while (p1.ifDead(p1, p2, gun)) {
			p1.printHealthBar(p1 , p2);
			gun.printslow(p1.getName() + "'s water gun is " + g1.getGunPower() + "% filled and will cause " + g1.getGunPower() + " damage to the enemy if used");
			gun.printslow("\n" + p2.getName() + "'s water gun is " + g2.getGunPower() + "% filled and will cause " + g2.getGunPower() + " damage to the enemy if used");
			if (isPlayer1Turn) {
				gun.printslow("\n" + firstPlayer + ", Chose your option (1. Fill your gun, 2. Attack " + secondPlayer + ")");
			} else {
				gun.printslow("\n" + secondPlayer + ", Choose your option (1. Fill your gun, 2. Attack " + firstPlayer + ")");
			}

			int action = prompt.nextInt();

			gun.clearScreen();
			switch (action) {

				case 1:
					if (isPlayer1Turn) {
						if (g1.getGunPower() >= 100) {
							gun.printslow("Gun is fully filled try again");
							Thread.sleep(1000);
							gun.clearScreen();
							continue;
						}
						gun.clearScreen();
						gun.printslow(p1.getName() + " has filled their gun");
						g1.fillGun(g1);
						gun.clearScreen();
					} else {
						if (g2.getGunPower() >= 100) {
							gun.printslow("Gun is fully filled try again");
							Thread.sleep(1000);
							gun.clearScreen();
							continue;
						}
						gun.clearScreen();
						gun.printslow(p2.getName() + " has filled their gun");
						g2.fillGun(g2);
						gun.clearScreen();
					}
					break;

				case 2:
					if (isPlayer1Turn) { 
						if (g1.getGunPower() == 0) {
							gun.clearScreen();
							gun.printslow("UhOh " + p1.getName() + "'s gun has no water in it");
							Thread.sleep(500);
							gun.clearScreen();
							break;
						}
						if (!g1.missedAttack()) {
							gun.clearScreen();
							gun.printslow(p1.getName() + "'s attack has been missed");
							Thread.sleep(500);
							gun.clearScreen();
							break;
						}
	
						int drained = g1.attack(p2, g1);	
						gun.printslow("Hooray!!!! Attack successfull " + p1.getName() + " has inflicted " + p2.getName() + " " + drained + " damage and now " + p2.getName() + " has " + p2.getHP() + " HP");
					} else {
						if (g2.getGunPower() == 0) {
							gun.printslow("UhOh " + p2.getName() + "'s gun has no water in it");
							Thread.sleep(500);
							gun.clearScreen();
							break;
						}
						if (!g2.missedAttack()) {
							gun.printslow(p2.getName() + "'s attack has been missed");
							Thread.sleep(500);
							gun.clearScreen();
							break;
						}
	
						int drained = g2.attack(p1, g2);	

						gun.printslow("Hooray!!!! Attack successfull " + p2.getName() + " has inflicted " + p1.getName() + " " + drained + " damage and now " + p1.getName() + " has " + p1.getHP() + " HP");
					}
					
					break;

				default:

					gun.clearScreen();
					gun.printslow("Invalid option try again");
					Thread.sleep(500);
					gun.clearScreen();
					continue;

			}
			
			isPlayer1Turn = !isPlayer1Turn;
		}
	}
}

