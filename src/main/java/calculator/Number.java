package calculator;

public class Number {
	public static final String REGEX_TEXT = "\\D";

	private final int number;

	public Number(String text) {
		if (isText(text)) {
			throw new RuntimeException();
		}

		this.number = Integer.parseInt(text);
		if (isNegative(this.number)) {
			throw new RuntimeException();
		}
	}

	private boolean isNegative(int no) {
		return no < 0;
	}

	private boolean isText(String text) {
		return text.matches(REGEX_TEXT);
	}
}
