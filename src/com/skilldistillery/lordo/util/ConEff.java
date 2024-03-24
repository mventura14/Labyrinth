package com.skilldistillery.lordo.util;

public class ConEff implements ConsoleEffect {

	public static void type(String consoleEffects, String message, int delayMs) {

		System.out.print(consoleEffects);

		for (char ch : message.toCharArray()) {
			System.out.print(ch);

			try {
				Thread.sleep(delayMs);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		System.out.print(reset);
	}

}
