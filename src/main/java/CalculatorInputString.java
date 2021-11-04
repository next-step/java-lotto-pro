public class CalculatorInputString {
	public static final String MESSAGE_VALUE_IS_NOT_NUMBER_FORMAT = "VALUE_IS_NOT_NUMBER_FORMAT";
	public static final String VALUE_ZERO = "0";

	private final String value;

	public CalculatorInputString(String value) {
		this.value = this.isEmpty(value) ? VALUE_ZERO : value;
	}

	private boolean isEmpty(String value) {
		return value == null || value.isEmpty();
	}

	public CalculatorNumbers toCalculateNumbers() {
		try {
			return new CalculatorNumbers(CalculatorInputStringParser.parse(value));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(MESSAGE_VALUE_IS_NOT_NUMBER_FORMAT);
		}
	}
}
