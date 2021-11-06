package model.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import utility.Assert;

public final class UserInputsSystem {

	private final GuidePrinter guidePrinter;
	private final Scanner scanner;
	private final int count;

	private UserInputsSystem(GuidePrinter guidePrinter, Scanner scanner, int count) {
		Assert.notNull(guidePrinter, "'guidePrinter' must not be null");
		Assert.notNull(scanner, "'scanner' must not be null");
		Assert.isTrue(moreThanZero(count), "'count' must be more than zero");
		this.guidePrinter = guidePrinter;
		this.scanner = scanner;
		this.count = count;
	}

	public static UserInputsSystem of(GuidePrinter guidePrinter, Scanner scanner, String count) {
		return new UserInputsSystem(guidePrinter, scanner, parseInt(count));
	}

	private static int parseInt(String count) {
		try {
			return Integer.parseInt(count);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(String.format("'count'(%s) must be number format", count), e);
		}
	}

	public Collection<String> inputs() {
		guidePrinter.print();
		ArrayList<String> inputs = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			inputs.add(scanner.nextLine());
		}
		return inputs;
	}

	private boolean moreThanZero(int count) {
		return count > 0;
	}
}
