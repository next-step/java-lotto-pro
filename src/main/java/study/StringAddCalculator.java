package study;

public class StringAddCalculator {

	public static int splitAndSum(String text) {
		if (isEmpty(text)) {
			return 0;
		}

		String[] numbers = split(text);

		return sum(numbers);
	}

	private static int sum(String[] numbers) {
		int sum = 0;
		for(String number : numbers){
			sum += parseInt(number);
		}
		return sum;
	}

	private static String[] split(String text) {
		return text.split(",|:");
	}

	private static int parseInt(String text) {
		return Integer.parseInt(text);
	}

	private static boolean isEmpty(String text) {
		return text == null || text.isEmpty();
	}
}
