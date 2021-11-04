package view;

import java.util.Scanner;

public final class UserInputSystem {

	private final GuidePrinter guidePrinter;
	private final Scanner scanner;

	private UserInputSystem(GuidePrinter guidePrinter, Scanner scanner) {
		validate(guidePrinter);
		validate(scanner);
		this.guidePrinter = guidePrinter;
		this.scanner = scanner;
	}

	public static UserInputSystem from(GuidePrinter guidePrinter, Scanner scanner) {
		return new UserInputSystem(guidePrinter, scanner);
	}

	public String input() {
		guidePrinter.print();
		return scanner.nextLine();
	}

	private void validate(GuidePrinter guidePrinter) {
		if (guidePrinter == null) {
			throw new IllegalArgumentException("'guidePrinter' must not be null");
		}
	}

	private void validate(Scanner scanner) {
		if (scanner == null) {
			throw new IllegalArgumentException("'scanner' must not be null");
		}
	}
}
