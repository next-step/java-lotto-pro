package stringaddcalculator;

public class StringAddCalculator {
	private static final int NULL_OR_EMPTY_DEFAULT_RETURN_VALUE = 0;

	public static int splitAndSum(String text) {
		if (isNullOrEmpty(text)) {
			return NULL_OR_EMPTY_DEFAULT_RETURN_VALUE;
		}
		String[] numberStrings = InputSplitter.splitText(text);
		Numbers numbers = Numbers.from(numberStrings);

		Number result = numbers.sum();
		return result.getValue();
	}

	private static boolean isNullOrEmpty(String text) {
		if (text == null) {
			return true;
		}
		return text.isEmpty();
	}
}
