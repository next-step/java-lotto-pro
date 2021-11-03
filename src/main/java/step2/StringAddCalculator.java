package step2;

public class StringAddCalculator {

	public static int splitAndSum(String s) {
		if (isNullOrEmpty(s)) {
			return 0;
		}
		return sum(StringAddParser.parse(s));
	}

	private static boolean isNullOrEmpty(String s) {
		return (null == s) || s.isEmpty();
	}

	private static int sum(StringAddParser.Result result) {
		int sum = 0;
		for (PositiveNumber number : result.getPositiveNumbers()) {
			sum += number.get();
		}
		return sum;
	}
}
