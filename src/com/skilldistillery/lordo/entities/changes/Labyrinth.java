package com.skilldistillery.lordo.entities.changes;

import java.util.Scanner;

import com.skilldistillery.lordo.entities.Player;
import com.skilldistillery.lordo.entities.player.Warrior;

public class Labyrinth {

//	private ArrayList<String> lostGameGrid;
//	private boolean cleared = false;
//	private int lostPath = 0;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Labyrinth game = new Labyrinth();
		PlayerMap pm = new PlayerMap();
		UI ui = new UI();
		Player player;

		do {
			player = new Warrior();

			ProcedualMap gPath = new ProcedualMap(8);
			gPath.showPath();
			ui.selection(sc, pm, gPath, player);

		} while (player.getAlive());

	}


}
