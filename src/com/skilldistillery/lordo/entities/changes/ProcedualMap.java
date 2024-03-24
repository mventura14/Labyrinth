package com.skilldistillery.lordo.entities.changes;

import java.util.ArrayList;
import java.util.Random;

import com.skilldistillery.lordo.util.ConsoleEffect;

public class ProcedualMap implements ConsoleEffect {
	private int pathLength = 7;
	private ArrayList<Character> procedualPath;
	private ArrayList<ArrayList<String>> gameGrid;
	private int px;
	private int py;

	public ProcedualMap() {
		procedualPath = generatePath(this.pathLength);
		gameGrid = generateGrid();
	}

	public ProcedualMap(int pathLength) {
		this.pathLength = pathLength;
		procedualPath = generatePath(this.pathLength);
		gameGrid = generateGrid();
	}

	private ArrayList<Character> generatePath(int pathLength) {
		Random random = new Random();
		Character[] wasd = { 'w', 'a', 's', 'd' };
		Character[] sdwa = { 's', 'd', 'w', 'a' };
		procedualPath = new ArrayList<>();

		while (procedualPath.size() < pathLength) {
			Character last;
			int count = 0;
			int num = random.nextInt(4);

			if (!procedualPath.isEmpty()) {

				last = procedualPath.get(procedualPath.size() - 1);

				while (wasd[num].equals(last) && count > 2) {
					num = random.nextInt(4);
				}
				for (int i = 0; i < 4; i++) {
					if (wasd[num].equals(wasd[i])) {
						if (last.equals(sdwa[num])) {
							procedualPath.remove(last);

						} else {
							procedualPath.add(wasd[num]);

						}
						if (wasd[num].equals(last)) {
							count++;
						} else {
							count = 0;
						}
					}
				}

			}

			else {
				procedualPath.add(wasd[num]);
			}
		}

		return procedualPath;
	}

	public void showPath() {
		String path = "";

		for (int i = 0; i < procedualPath.size() - 1; i++) {

			if (i != 0) {
				path += ", ";
			}
			if (procedualPath.get(i) == 'w') {
				path += "North";
			}
			if (procedualPath.get(i) == 's') {
				path += "South";
			}
			if (procedualPath.get(i) == 'a') {
				path += "East";
			}
			if (procedualPath.get(i) == 'd') {
				path += "West";
			}

		}
		System.out.println(path);
	}

	public ArrayList<ArrayList<String>> generateGrid() {
		gameGrid = new ArrayList<ArrayList<String>>();

		ArrayList<String> start = new ArrayList<>();

		start.add(red + "Start" + reset);

		gameGrid.add(start);

		return gameGrid;
	}

	public void addRowT() {
		int longestRow = gameGrid.get(0).size();

		ArrayList<String> arr = new ArrayList<>();

		for (int i = 0; i < longestRow; i++) {
			arr.add("    ");
		}

		gameGrid.add(0, arr);
	}

	public void addRowB() {

		int longestRow = gameGrid.get(0).size();

		ArrayList<String> arr = new ArrayList<>();

		for (int i = 0; i < longestRow; i++) {
			arr.add("    ");
		}

		gameGrid.add(arr);

	}

	public void addColL() {

		for (ArrayList<String> row : gameGrid) {
			row.add(0, "    ");
		}

	}

	public void addColR() {
		for (ArrayList<String> row : gameGrid) {
			row.add("    ");
		}
	}

	public void showGrid() {

		for (ArrayList<String> arr : gameGrid) {
			System.out.println(arr);
		}

		System.out.println(reset);
	}

	public void cord() {
		System.out.println("x: " + px + " y: " + py);
	}

	public void prevPosition() {

		if (gameGrid.get(px).get(py).equals(green + "Here " + reset)) {
			gameGrid.get(this.px).set(this.py, yellow + "Was " + reset);

		}

	}

	public void currentPosition() {

		if (!gameGrid.get(this.px).get(this.py).equals(red + "Start" + reset)) {

			gameGrid.get(this.px).set(this.py, green + "Here " + reset);
		}

	}

	public void backtrack(Character selection, int initPlayerMapLength, int currentPlayerMapLength) {

		if (currentPlayerMapLength < initPlayerMapLength) {
			switch (selection) {

			case 'w':
				gameGrid.get(this.px + 1).set(this.py, "    ");
				break;
			case 'a':
				gameGrid.get(this.px).set(this.py + 1, "    ");
				break;
			case 's':
				gameGrid.get(this.px - 1).set(this.py, "    ");
				break;
			case 'd':
				gameGrid.get(this.px).set(this.py - 1, "    ");
				break;
			default:
				System.out.println("Something went wrong");

			}
		}
	}

	public void devMap() {

		showGrid();
	}

	public void removeTop() {
		if (!gameGrid.isEmpty()) {
			ArrayList<String> topRow = gameGrid.get(0);
			if (topRow.stream().allMatch(String::isBlank)) {
				gameGrid.remove(0);
				px--;
			}
		}
	}

	public void removeBottom() {
		if (!gameGrid.isEmpty()) {
			int lastRowIndex = gameGrid.size() - 1;
			ArrayList<String> bottomRow = gameGrid.get(lastRowIndex);
			if (bottomRow.stream().allMatch(String::isBlank)) {
				gameGrid.remove(lastRowIndex);
			}
		}
	}

	public void removeLeft() {
		boolean removeLeft = true;

		for (ArrayList<String> row : gameGrid) {
			if (!row.isEmpty() && !row.get(0).isBlank()) {
				removeLeft = false;
				break;

			}
		}

		if (removeLeft) {
			for (ArrayList<String> row : gameGrid) {
				row.remove(0);

			}
			this.py--;

		}

	}

	public void removeRight() {

		boolean removeRight = true;

		for (ArrayList<String> row : gameGrid) {
			if (!row.isEmpty() && !row.get(row.size() - 1).isBlank()) {
				removeRight = false;
				break;
			}
		}

		if (removeRight) {
			for (ArrayList<String> row : gameGrid) {
				if (!row.isEmpty()) {
					row.remove(row.size() - 1);
				}
			}
		}
	}

	public void dynamicGrid(Character step, int pPath1, int pPath2) {
		this.prevPosition();

		if (step.equals('w')) {
			if (this.px == 0) {
				this.addRowT();
			} else {
				this.px--;
			}
		}
		if (step.equals('s')) {
			if (this.px == this.gameGrid.size() - 1) {
				this.addRowB();
				this.px++;
			} else {
				this.px++;
			}
		}
		if (step.equals('a')) {
			if (this.py == 0) {
				this.addColL();
			} else {
				py--;
			}
		}
		if (step.equals('d')) {
			if (this.py == this.gameGrid.get(0).size() - 1) {
				this.addColR();
				this.py++;
			} else {
				this.py++;
			}
		}

		this.currentPosition();

		if (pPath1 > pPath2) {
			System.out.println(magenta + "Backtracked" + reset);
			backtrack(step, pPath1, pPath2);
		}

		switch (step) {
		case 'w':
			this.removeBottom();
			break;
		case 'a':
			removeRight();
			break;
		case 's':
			this.removeTop();
			break;
		case 'd':
			this.removeLeft();
			break;

		}

	}
}
