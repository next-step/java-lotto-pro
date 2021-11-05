public class CalculatorNumber {
	public static final String MESSAGE_ILLEGAL_NEGATIVE_NUMBER = "MESSAGE_ILLEGAL_NEGATIVE_NUMBER";

	private final int value;

	public CalculatorNumber(int value) {
		if (value < 0) {
			throw new IllegalArgumentException(MESSAGE_ILLEGAL_NEGATIVE_NUMBER);
		}
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
