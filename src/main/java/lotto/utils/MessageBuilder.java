package lotto.utils;

public class MessageBuilder {

	private MessageBuilder() {}

	public static String build(String message, Object... args) {
		return String.format(message, args);
	}
}
