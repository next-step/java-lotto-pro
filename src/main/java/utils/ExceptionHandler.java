package utils;

import java.util.function.Supplier;

public class ExceptionHandler {

	public static <T> T callWithHandlingException(Supplier<T> supplier) {
		return callWithHandlingException("", "", supplier);
	}

	public static <T> T callWithHandlingException(String prompt, Supplier<T> supplier) {
		return callWithHandlingException(prompt, "", supplier);
	}

	public static <T> T callWithHandlingException(String prompt, String exceptionMessage, Supplier<T> supplier) {
		try {
			printPrompt(prompt);
			return supplier.get();
		} catch (Exception e) {
			printExceptionMessage(exceptionMessage, e);
			return callWithHandlingException(prompt, exceptionMessage, supplier);
		}
	}

	private static void printPrompt(String prompt) {
		System.out.println(prompt);
	}

	private static void printExceptionMessage(String customExceptionMessage, Exception e) {
		String exceptionMessage = customExceptionMessage.isEmpty() ? e.getMessage() : customExceptionMessage;
		System.out.println(exceptionMessage);
	}

}
