package model.common;

import java.util.Scanner;

import utility.Assert;

public final class UserInputSystem {

	private final GuidePrinter guidePrinter;
	private final Scanner scanner;

	private UserInputSystem(GuidePrinter guidePrinter, Scanner scanner) {
		Assert.notNull(scanner, "'scanner' must not be null");
		validate(guidePrinter);
		this.guidePrinter = guidePrinter;
		this.scanner = scanner;
	}

	public static UserInputSystem of(GuidePrinter guidePrinter, Scanner scanner) {
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
			throw new IllegalArgumentException();
		}
	}
}
