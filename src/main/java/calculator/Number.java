package calculator;

public class Number {
	public static final String REGEX_TEXT = "\\D";

	private final int number;

	public Number(String text) {
		if (isText(text)) {
			throw new RuntimeException("문자는 입력 할 수 없습니다.");
		}

		this.number = Integer.parseInt(text);
		if (isNegative(this.number)) {
			throw new RuntimeException("음수는 입력 할 수 없습니다.");
		}
	}

	private boolean isNegative(int no) {
		return no < 0;
	}

	private boolean isText(String text) {
		return text.matches(REGEX_TEXT);
	}
}
