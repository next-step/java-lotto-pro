package view;

import java.util.Scanner;

public class CustomScanner {
	private static Scanner scanner;

	private CustomScanner() {
	}

	public static String readLine() {
		return getInstance().nextLine();
	}

	private static Scanner getInstance() {
		if (scanner == null) {
			scanner = new Scanner(System.in);
		}
		return scanner;
	}
}
