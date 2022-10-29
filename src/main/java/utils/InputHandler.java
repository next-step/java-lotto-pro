package utils;

import java.util.Scanner;

public class InputHandler {

	private static final Scanner scanner = new Scanner(System.in);

	public static String input() {
		return scanner.next();
	}

	public static int inputInteger() {
		return Integer.parseInt(input());
	}

}
