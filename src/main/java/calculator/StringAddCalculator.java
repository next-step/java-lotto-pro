package calculator;

public class StringAddCalculator {
	private StringAddCalculator() {
	}

	public static int splitAndSum(String input) {
		Calculator calculator = new Calculator(input);
		return calculator.getSum();
	}

}
