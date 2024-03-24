package com.skilldistillery.lordo.entities;

import java.util.ArrayList;
import java.util.Random;

import com.skilldistillery.lordo.util.Direction;

public class Maze implements Direction {
	private int pathSize = 4;
	private ArrayList<String> path;

	public static void main(String[] args) {
		Maze m = new Maze();
		System.out.println(m.path);

		m.type("Howdy Yall", 100);
	}

	public Maze() {
		this.path = generatePath(pathSize);
	}

	public void type(String message, int delayMs) {
		for (char ch : message.toCharArray()) {
			System.out.print(ch);

			try {
				Thread.sleep(delayMs);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private ArrayList<String> generatePath(int length) {
		path = new ArrayList<String>();

		Random random = new Random();

		while (path.size() <= length) {

			int randomNum = random.nextInt(4) + 1;

			int test = randomNum % 2 == 0 ? randomNum - 2 : randomNum;

			if (path.size() < 1) {
				path.add(dir[randomNum - 1]);
			} else {

				if (dir[test].equals(getLast())) {
					path.remove(path.size() - 1);
//				System.out.println("removed");
				} else {
					path.add(dir[randomNum - 1]);
				}
			}

		}

		return path;

	}

	public String getLast() {
		return this.path.get(path.size() - 1);
	}

	public ArrayList<String> getPath() {
		return path;
	}

}
