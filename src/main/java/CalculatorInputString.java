import java.util.List;

public class CalculatorInputString {
	public static final String MESSAGE_VALUE_IS_NOT_NUMBER_FORMAT = "VALUE_IS_NOT_NUMBER_FORMAT";
	private final String value;

	public CalculatorInputString(String value) {
		this.value = value;
	}

	public boolean isEmpty() {
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
