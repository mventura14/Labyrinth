package com.skilldistillery.lordo.entities.changes;

import java.util.Scanner;

import com.skilldistillery.lordo.entities.Player;
import com.skilldistillery.lordo.util.VerifyScan;



public class UI {

	public void selection(Scanner sc, PlayerMap pm, ProcedualMap gGrid, Player player) {
		while (player.getAlive()) {
//			
			
			int playerMapSize = pm.size();

			char userInput = VerifyScan.validChar(sc, "wasdpm", "Selection: ");
			
			if (userInput == 'w') {
				pm.updateMap(userInput);
				gGrid.dynamicGrid(userInput, playerMapSize, pm.size());
			}
			if (userInput == 'a') {
				pm.updateMap(userInput);
				gGrid.dynamicGrid(userInput, playerMapSize, pm.size());
			}

			if (userInput == 's') {
				System.out.println("Calling Map");
				pm.updateMap(userInput);
				gGrid.dynamicGrid(userInput, playerMapSize, pm.size());

			}
			if (userInput == 'd') {
				pm.updateMap(userInput);
				gGrid.dynamicGrid(userInput, playerMapSize, pm.size());
			}
			if (userInput == 'p') {
				System.out.println("OWWW, My Leg!!!!");
				gGrid.cord();
			}
			if (userInput == 'm') {
				pm.showMap();
				gGrid.devMap();
			}



			gGrid.devMap();
		}
	}
}
