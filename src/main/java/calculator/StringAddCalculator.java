package calculator;

import calculator.utils.StringUtils;

public class StringAddCalculator {
	private static final int SUM_INIT_VALUE = 0;

	public static int splitAndSum(String text) {
		if (StringUtils.isEmpty(text)) {
			return SUM_INIT_VALUE;
		}

		String[] splitInputs = StringSplitter.split(text);
		return SUM_INIT_VALUE;
	}
}
