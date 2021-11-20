package lotto.view;

import utils.Console;

public class CustomerConsole {
	private static final String ERROR_PREFIX = "[ERROR] ";

	protected static String ask(String errorMessage) {
		try {
			return Console.read();
		} catch (Exception e) {
			System.out.println(ERROR_PREFIX + errorMessage);
			return ask(errorMessage);
		}
	}

	protected static String withErrorPrefix(String errorMessage) {
		return ERROR_PREFIX + errorMessage;
	}
}
