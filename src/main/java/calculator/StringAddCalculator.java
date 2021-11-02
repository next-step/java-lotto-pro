package calculator;

public class StringAddCalculator {

	public static int splitAndSum(String input) {
		Calculator calculator = new Calculator(input);
		return calculator.getSum();
	}

}
