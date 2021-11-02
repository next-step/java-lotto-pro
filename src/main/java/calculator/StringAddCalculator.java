package calculator;

import java.util.Arrays;

public class StringAddCalculator {

	public static int splitAndSum(String text) {
		if (ValidationUtils.isEmpty(text)) {
			return 0;
		}
		String[] numbers = SplitText.split(text);
		ValidationUtils.checkNumber(numbers);
		
		return sum(numbers);
	}

	private static int sum(String[] numbers) {
		return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
	}

}
