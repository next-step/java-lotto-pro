public class CalculatorInputString {
	private final String value;

	public CalculatorInputString(String value) {
		this.value = value;
	}

	public boolean isEmpty() {
		return value == null || value.isEmpty();
	}

	public CalculatorNumbers toCalculatorNumbers() {
		return null;
	}
}
