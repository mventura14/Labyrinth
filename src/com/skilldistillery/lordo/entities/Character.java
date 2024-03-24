package com.skilldistillery.lordo.entities;

public class Character {

	private String name;
	protected int hp;
	private int health;
	private int defense;
	private int strength;
	private int magic;

	public Character(String name, int health, int defense, int strength, int magic) {
		super();
		this.name = name;
		this.hp = health * 10;
		this.health = health;
		this.defense = defense;
		this.strength = strength;
		this.magic = magic;
	}

	public String getStats() {
		String[] skillName = { "Health", "Defence", "Strength", "Magic" };
		int[] skillLevel = { this.health, this.defense, this.strength, this.magic };

		String stats = "";

		for (int i = 0; i < skillName.length; i++) {

			stats += skillName[i] + ": " + skillLevel[i] + "\n";

		}

		return stats;
	}

	public int getSkill(String skill) {

		switch (skill) {


		case "health":
			return this.health;
		case "defence":
			return this.defense;
		case "strength":
			return this.strength;
		case "magic":
			return this.magic;
		default:
			System.out.println("No Such Skill");
			return 0;
		}

	}

	protected void setSkill(String skill, int amount) {

		switch (skill) {

		case "health":
			this.health += amount;
			break;
		case "defense":
			this.defense += amount;
			break;
		case "strength":
			this.strength += amount;
			break;
		case "magic":
			this.magic += amount;
			break;
		default:
			System.out.println("No Such Skill");
		}

	}

	public void reduceHp(int amount) {
		this.hp = this.hp - amount;
		
//		if (this.hp < 0) {
//			this.hp = 0;
//		}

	};

	public void increaseHp(int amount) {

		this.hp += amount;
		this.hp = this.hp < (this.health * 10) ? this.hp : this.health * 10;

	}

	public int getHP() {
		return this.hp;
	}

	public String getName() {
		return this.name;
	}

	public int attack(String type) {

		switch (type) {
		case "melle":
			return this.strength;

		case "magic":
			return this.magic;

		default:
			return 0;
		}
	}
}

