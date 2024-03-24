package com.skilldistillery.lordo.entities;

import java.util.Random;
import java.util.Scanner;

import com.skilldistillery.lordo.entities.gametext.GameSelections;
import com.skilldistillery.lordo.entities.items.Map;
import com.skilldistillery.lordo.entities.mob.Goblin;
import com.skilldistillery.lordo.entities.mob.Troll;
import com.skilldistillery.lordo.entities.player.Warrior;
import com.skilldistillery.lordo.util.ConEff;
import com.skilldistillery.lordo.util.ConsoleEffect;
import com.skilldistillery.lordo.util.Direction;
import com.skilldistillery.lordo.util.VerifyScan;
import com.skilldistillery.lordo.util.mUtil;

public class Labyrith implements Direction, ConsoleEffect {
	private boolean alive = true;
	private boolean cleared = false;
	public int lostPath = 0;

	public void run() {
		Labyrith game = new Labyrith();
		Scanner sc = new Scanner(System.in);
		GameSelections menu = new GameSelections();

		Map map = new Map();
		Maze path = new Maze();

//		menu.welcome();

//		Player player = menu.playerSelection(sc, green + "Choose Wisely... :" + reset);

		Warrior player = new Warrior();

//		menu.intro(sc, player);

		while (true) {
			boolean died = game.whichDirection(player, sc, map, path, menu);
//			System.out.println(died);
		}

	}

	public boolean whichDirection(Player player, Scanner sc, Map map, Maze path, GameSelections menu) {
		boolean isAlive = true;
		boolean onPath = true;
		int userselection = 0;
		String message;

		if (player.hasMap()) {
			message = red
					+ "Which direction would you like to go? 1:North, 2:South, 3:East, 4:West, 5:Check Stats, 6:Check Map"
					+ reset;
			int selectChoice = VerifyScan.inputValidation(sc, "int", message, 0, 7);
			userselection = selectChoice;

			if (selectChoice == 1) {

				System.out.println("\nYou head North. ");
			}
			if (selectChoice == 2) {
				System.out.println("\nYou head South.");
			}
			if (selectChoice == 3) {
				System.out.println("\nYou head East. ");
			}
			if (selectChoice == 4) {
				System.out.println("\nYou head West");
			}
			if (selectChoice == 5) {
				ConEff.type(bgreen, player.getStats() + "\n", 10);
			}
			if (selectChoice == 6) {

				ConEff.type(bgreen, map.getPath().toString() + "\n", 20);
			}

			if (selectChoice < 5) {
				updateMap(selectChoice, map, path);
			}

		}

		else if (!player.hasMap()) {
			message = red + "Which direction would you like to go? 1:North, 2:South, 3:East, 4:West, 5:Check Stats\n"
					+ reset;
			int selectChoice = VerifyScan.inputValidation(sc, "int", message, 0, 6);
			userselection = selectChoice;
			if (selectChoice == 1) {
				System.out.println("\nYou head North. ");
			}
			if (selectChoice == 2) {
				System.out.println("\nYou head South.");
			}
			if (selectChoice == 3) {
				System.out.println("\nYou head East. ");
			}
			if (selectChoice == 4) {
				System.out.println("\nYou head West");
			}
			if (selectChoice == 5) {
				System.out.println("Hp: " + player.getHP());
				ConEff.type(bgreen, player.getStats() + "\n", 10);
			}

			if (selectChoice < 5) {
				updateMap(selectChoice, map, path);
			}
		}

		onPath = testPass(map, path);

//		System.out.println("whichDirection: testPath: " + onPath);

// Add Random events here + sub menus 		
		if (userselection < 5) {
			checkForEvent(onPath, map, path, player);
		}

		if (onPath == true && (map.getPath().size() == path.getPath().size())) {
			System.out.println(red + "Enough you already Won...All hail the Champion of the Labyrinth" + reset);
		}

		if (player.getHP() == 0) {
			menu.youDied();
			isAlive = false;
		}
		return isAlive;
	}

	public void updateMap(int selection, Map map, Maze path) {

		if (map.getPath() != null) {
			System.out.println(byellow + "Dev-updateMap:" + "" + path.getPath());
//			System.out.println(updateMap: map.getPath());

		}

		if (map.getPath().size() < 1) {

			map.add(dir[selection - 1]);

		} else {

			if (selection == 1) {

				testBackTrack(map, selection);
			}
			if (selection == 2) {
				testBackTrack(map, selection);
			}
			if (selection == 3) {
				testBackTrack(map, selection);
			}
			if (selection == 4) {
				testBackTrack(map, selection);
			}

		}

//		System.out.println(byellow + "Dev-updateMap:" + map.getPath() + reset);

	}

	private void testBackTrack(Map map, int selection) {
		int test = selection % 2 == 0 ? selection - 2 : selection;
//		System.out.println("testBackTrack: " + test);
//		System.out.println("testBackTrack: " + dir[test]);
		if (map.getPath().size() > 0) {
			if (dir[test].equals(map.getPath().get(map.getPath().size() - 1))) {
				map.remove(map.getPath().size() - 1);
//				System.out.println("removed");
			} else {
				map.add(dir[selection - 1]);
			}
		}

	}

	@SuppressWarnings("unused")
	private boolean testPass(Map map, Maze path) {
		boolean onPath = false;

		if (map.getPath().size() > 0) {

			int playerPathLength = map.getPath().size() - 1;
			int getlowest = path.getPath().size() > map.getPath().size() ? map.getPath().size() - 1
					: path.getPath().size() - 1;

			if (playerPathLength <= path.getPath().size()) {
				if ((map.getLast().equals(path.getLast()) && (map.getLast() != null)))

					for (int i = 0; i < getlowest; i++) {
						if (!(path.getPath().get(i).equals(map.getPath().get(i)))) {
//							System.out.println("testpath: reaches false");
							this.lostPath = i;
							return false;
//							System.out.println(red + onPath + reset);

						} else {
//							System.out.println("testpath: reaches true");
							return true;

						}

					}

			}

		}
		return onPath;

	};

	private void checkForEvent(boolean onPath, Map map, Maze path, Player player) {

		int randomNum = diceRoll(100);

		if ((onPath == false) && this.lostPath + 2 < map.getPath().size()) {
			System.out.println(green + "checkForEvent: Testing for event" + reset);

			if (randomNum % 5 == 0) {
				randomLoot(player);

//				ConEff.type(bgreen, "You are lucky... you found a chest filled with loot.\nlets see what you got...\n",
//						20);
			} else if (randomNum % 3 == 0) {
				Creature mob = new Creature();
				ConEff.type(bred, "A " + mob.getName() + " is Spawning\n", 20);
				combat(mob, player);

			}
		}

	}

	private int diceRoll(int diceSize) {

		Random random = new Random();

		int randomNum = random.nextInt(diceSize) + 1;

//		System.out.println(red + randomNum + reset);

		return randomNum;

	}

	private void randomLoot(Player player) {
		int lootNum = diceRoll(4) + 1;

		if (lootNum == 1) {
			System.out.println(bgreen + "\nYou tripped...on...a health potion!");
			player.increaseHp(diceRoll(5));
		}
		if (lootNum == 2) {
			System.out.println(bgreen + "\nIt's your lucky day you found some loot its an Attack Power Up!");
			player.levelUp("attack");
		}
		if (lootNum == 3) {
			System.out.println(bgreen + "\nGood karma smiles upon you...here is some bonus Defense.");
			player.levelUp("defense");
		}
		if (lootNum == 4) {
			if (player.hasMap()) {
				System.out.println(bgreen + "Wow a two stat PowerUp Atack and Deffense ");
				player.levelUp("defense");
				player.levelUp("attack");
			} else {
				System.out.println(bgreen + "\nYou lucky litlle booger you found a map to the Labyrinth.");
				player.giveMap();
			}

		}
	}

	private Creature randomMonsterSpawn() {

		int randomNum = diceRoll(2);
		switch (randomNum) {
		case 1:
			Creature troll = new Troll();
			return troll;
		case 2:
			Creature goblin = new Goblin();
			return goblin;
		default:
			return new Creature();

		}
	}


	public void combat(Creature opponent, Player player) {
		int damage;

		System.out.println(opponent.getName() + ": " + opponent.getHP());
		System.out.println(player.getName() + ": " + player.getHP());

		while (opponent.getHP() > 0 && player.getHP() > 0) {

//		Opponent
			if (mUtil.diceRoll(6) > mUtil.diceRoll(20)) {
				damage = opponent.getSkill("strength");
				player.reduceHp(damage);
				System.out.println(red + "Hit: " + damage + reset);
			} else {
				System.out.println(blue + "Dodged" + reset);
			}

//		Player
			if (mUtil.diceRoll(20) > mUtil.diceRoll(20)) {
				damage = player.getSkill("strength");
				opponent.reduceHp(damage);
				System.out.println(green + "Hit: " + damage + reset);
			} else {
				System.out.println(red + "miss" + reset);
			}
		}

		if (opponent.getHP() == 0) {

			System.out.println("The " + opponent.getName().toLowerCase() + " Was slayed");
			System.out.println(player.getName() + ": " + player.getHP());
		} else {
			System.out.println(bred + "You are dead" + reset);
		}

	}

}
