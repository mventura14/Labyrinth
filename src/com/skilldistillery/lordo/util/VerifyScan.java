package com.skilldistillery.lordo.util;

import java.util.Scanner;

public final class VerifyScan {

	public void type() {

		int delayMilliseconds = 1000;
		String message = "";

		for (char ch : message.toCharArray()) {
			System.out.print(ch + " ");

			try {
				Thread.sleep(delayMilliseconds);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	@SuppressWarnings("unchecked")
	public static <T> T inputValidation(Scanner sc, String type, String message) {

		switch (type) {
		case "int":
			return (T) Integer.valueOf(intScan(sc, message));

		case "double":
			return (T) Double.valueOf(doubleScan(sc, message));

		case "long":
			return (T) Long.valueOf(longScan(sc, message));
		default:
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T inputValidation(Scanner sc, String type, String message, int min, int max) {

		switch (type) {
		case "int":
			return (T) Integer.valueOf(intScan(sc, message, min, max));
		default:
			return null;
		}
	}

	private static long longScan(Scanner sc, String message) {
		long userInput = 0;
		boolean isValidInput = false;

		while (!isValidInput) {
			System.out.print(message);
			if (sc.hasNextLong()) {
				userInput = sc.nextLong();
				isValidInput = true;
			} else {
				sc.next();
			}
		}
		return userInput;
	}

	private static double doubleScan(Scanner sc, String message) {

		double userInput = 0;
		boolean isValidInput = false;

		while (!isValidInput) {
			System.out.print(message);
			if (sc.hasNextDouble()) {
				userInput = sc.nextDouble();
				isValidInput = true;
			} else {
				sc.next();
			}
		}
		return userInput;
	}

	private static int intScan(Scanner sc, String message) {
		int userInput = 0;
		boolean isValidInput = false;

		while (!isValidInput) {
			System.out.print(message);
			if (sc.hasNextInt()) {
				userInput = sc.nextInt();
				isValidInput = true;
			} else {
				sc.next();
			}
		}

		return userInput;
	}

	private static int intScan(Scanner sc, String message, int min, int max) {
		int userInput = 0;
		boolean isValidInput = false;

		while (!isValidInput) {
			System.out.print(message);
			if (sc.hasNextInt()) {
				userInput = sc.nextInt();
				if (userInput > min && userInput < max) {
					isValidInput = true;
				}
			} else {
				sc.next();
			}
		}
		return userInput;

	}

	@SuppressWarnings("unused")

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

}
