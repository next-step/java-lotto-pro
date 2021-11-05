public class StringAddCalculator {
	public int splitAndSum(String source) {
		CalculatorInputString calculatorInputString = new CalculatorInputString(source);

		CalculatorNumbers calculatorNumbers = calculatorInputString.toCalculateNumbers();
		return calculatorNumbers.sum();
	}
}
