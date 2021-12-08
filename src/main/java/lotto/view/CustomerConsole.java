package lotto.view;

import utils.Console;

public class CustomerConsole {
	private static final String ERROR_PREFIX = "[ERROR] ";

	protected static String ask() {
		try {
			return Console.read();
		} catch (Exception e) {
			return ask();
		}
	}

	protected static String withErrorPrefix(String errorMessage) {
		return ERROR_PREFIX + errorMessage;
	}
}
