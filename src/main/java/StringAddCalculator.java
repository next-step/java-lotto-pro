public class StringAddCalculator {
	public static final String MESSAGE_HAS_NEGATIVE_NUMBER = "HAS_NEGATIVE_NUMBER";

	public int splitAndSum(String source) {
		CalculatorInputString calculatorInputString = new CalculatorInputString(source);
		if (calculatorInputString.isEmpty()) {
			return 0;
		}

		CalculatorNumbers calculatorNumbers = calculatorInputString.toCalculateNumbers();
		if (calculatorNumbers.hasSingleNumber()) {
			return calculatorNumbers.getNumber(0);
		}
		if (calculatorNumbers.containExceptional()) {
			throw new IllegalArgumentException(MESSAGE_HAS_NEGATIVE_NUMBER);
		}
		return calculatorNumbers.sum();
	}
}
