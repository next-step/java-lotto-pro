package lottoservice.ui;

import java.util.Scanner;

public class InputView {
	private InputView(){
	}

	private static Scanner scanner = getScanner();

	public static String readLine() {
		return scanner.nextLine();
	}
	private static Scanner getScanner() {
		return new Scanner(System.in);
	}
}
