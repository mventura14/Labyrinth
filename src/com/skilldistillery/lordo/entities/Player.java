package com.skilldistillery.lordo.entities;

public class Player extends Character {
	boolean alive = true;
	boolean map = false;


	public Player(String name, int health, int defense, int strength, int magic) {
		super(name, health, defense, strength, magic);

	}



	public Boolean hasMap() {
		return map;
	}

	public void giveMap() {
		this.map = true;
	}


	public void levelUp(String skill) {
			
		this.setSkill(skill, 1);
		
	}

	public void reduceHp(int amount) {
		this.hp -= amount;

		if (this.hp < 0) {
			this.hp = 0;
			this.alive = false;
		}

	}

	public boolean getAlive() {
		return this.alive;
	}

}
