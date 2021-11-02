package utility;

final class StringNumber {

	private static final int DEFAULT_EMPTY_INT = 0;

	private final String string;

	private StringNumber(String string) {
		this.string = string;
	}

	public static StringNumber of(String string) {
		return new StringNumber(string);
	}

	public int parseInt() {
		if (isEmptyString()) {
			return DEFAULT_EMPTY_INT;
		}
		int number = Integer.parseInt(string);
		validate(number);
		return number;
	}

	@Override
	public String toString() {
		return "StringNumber{" +
			"string='" + string + '\'' +
			'}';
	}

	private boolean isEmptyString() {
		return string == null || string.trim().isEmpty();
	}

	private void validate(int number) {
		if (isNegative(number)) {
			throw new RuntimeException(String.format("Number(%d) must not be negative", number));
		}
	}

	private boolean isNegative(int number) {
		return number < 0;
	}
}
