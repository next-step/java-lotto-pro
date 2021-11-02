package utility;

final class StringNumber {

	private final String string;

	private StringNumber(String string) {
		this.string = string;
	}

	public static StringNumber of(String string) {
		return new StringNumber(string);
	}

	public int parseInt() {
		if (isEmptyString()) {
			return 0;
		}
		int number = Integer.parseInt(string);
		validate(number);
		return number;
	}

	private boolean isEmptyString() {
		return string == null || string.trim().isEmpty();
	}

	private void validate(int number) {
		if (number < 0) {
			throw new RuntimeException(String.format("Number(%d) must not be negative", number));
		}
	}
}
