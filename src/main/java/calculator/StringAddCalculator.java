package calculator;

public class StringAddCalculator {

	public static int splitAndSum(String input) {
		Sum sum = new Sum(new Split(input));
		return sum.getSum();
	}
}
