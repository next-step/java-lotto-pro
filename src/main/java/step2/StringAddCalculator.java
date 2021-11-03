package step2;

import java.util.List;

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

	private static int sum(List<PositiveNumber> positiveNumbers) {
		return positiveNumbers.stream()
			.reduce(PositiveNumber.from("0"), PositiveNumber::add)
			.get();
	}
}
