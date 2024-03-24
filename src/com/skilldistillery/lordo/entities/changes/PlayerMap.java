package com.skilldistillery.lordo.entities.changes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerMap {
	private ArrayList<Character> playerPath = new ArrayList<>();

	public PlayerMap() {
	};

	public void updateMap(char userInput) {
		int last = playerPath.size() - 1;

		if (playerPath.isEmpty()) {
			playerPath.add(userInput);
		} else {
			if (userInput == 'w') {
				if (playerPath.get(playerPath.size() - 1) == 's') {
					playerPath.remove(last);
				} else {
					playerPath.add(userInput);
				}
			}
			if (userInput == 'a') {
				if (playerPath.get(playerPath.size() - 1) == 'd') {
					playerPath.remove(last);
				} else {
					playerPath.add(userInput);
				}
			}
			if (userInput == 's') {
				if (playerPath.get(playerPath.size() - 1) == 'w') {
					playerPath.remove(last);
				} else {
					playerPath.add(userInput);
				}
			}
			if (userInput == 'd') {
				if (playerPath.get(playerPath.size() - 1) == 'a') {
					playerPath.remove(last);
				} else {
					playerPath.add(userInput);
				}
			}
		}
		System.out.println(playerPath);

	}

	public static char validChar(Scanner scanner, String valid, String message) {
		char direction;
		while (true) {
			System.out.print(message);
			String input = scanner.nextLine();
			if (input.length() == 1 && valid.contains(input)) {
				direction = input.charAt(0);
				break;
			} else {

			}
		}
		return direction;
	}

	public void showMap() {
		String path = "";

		List<Character> playerPath1 = playerPath.subList(Math.max(playerPath.size() - 5, 0), playerPath.size());

		for (int i = 0; i < playerPath1.size(); i++) {

			if (i != 0) {
				if (i % 10 == 0) {
					path += "\n";
				} else {
					path += ", ";
				}
				if (playerPath1.get(i) == 'w') {
					path += "North";
				}
				if (playerPath1.get(i) == 's') {
					path += "South";
				}
				if (playerPath1.get(i) == 'a') {
					path += "East";
				}
				if (playerPath1.get(i) == 'd') {
					path += "West";
				}

			} else {
				if (playerPath1.get(i) == 'w') {
					path += "North";
				}
				if (playerPath1.get(i) == 's') {
					path += "South";
				}
				if (playerPath1.get(i) == 'a') {
					path += "East";
				}
				if (playerPath1.get(i) == 'd') {
					path += "West";
				}
			}
		}

		if (path.isBlank()) {
			System.out.println("You Gaze Upon your map and see nothing...");
		} else {
			System.out.println(path);
		}

	}

	public int size() {

		return this.playerPath.size();
	}

}
