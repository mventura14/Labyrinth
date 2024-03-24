package com.skilldistillery.lordo.util;

import java.util.Random;

public class mUtil {

	public static int diceRoll(int diceSize) {

		Random random = new Random();

		int randomNum = random.nextInt(diceSize) + 1;

		return randomNum;

	}

}
