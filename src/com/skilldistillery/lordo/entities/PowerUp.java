package com.skilldistillery.lordo.entities;

import java.util.Random;

import com.skilldistillery.lordo.util.ConsoleEffect;

public class PowerUp implements ConsoleEffect {



	public int attackPowerUp() {
		Random random = new Random();
		int rndmPwrUpNum = random.nextInt(15) + 1;
		System.out.println(green + "You recieved an Attack power up + " + rndmPwrUpNum + " to AP");
		return rndmPwrUpNum;
	}

	public int defensePowerUp() {
		Random random = new Random();
		int rndmPwrUpNum = random.nextInt(15) + 1;
		System.out.println(green + "You recieved an Defense power up + " + rndmPwrUpNum + " to DP");
		return rndmPwrUpNum;
	}

	public int hitPointPowerUp() {
		Random random = new Random();
		int rndmPwrUpNum = random.nextInt(15) + 1;
		System.out.println(green + "You recieved an Hit Points power up +" + rndmPwrUpNum + "to AP");
		return rndmPwrUpNum;
	}

	public void healPotion() {
		System.out.println(green + "You recieved a healing potion...Be Healed!!! 20 HP has been restored.");
	}
}
