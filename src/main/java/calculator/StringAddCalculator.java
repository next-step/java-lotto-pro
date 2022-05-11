package calculator;

public class StringAddCalculator {
	private StringAddCalculator() {

	}

	public static int splitAndSum(String string) {
		return Numbers.from(string)
				.sum()
				.getValue();
	}
}
