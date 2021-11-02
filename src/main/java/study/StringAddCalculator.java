package study;

public class StringAddCalculator {

	public static int splitAndSum(String text) {
		if (isEmpty(text)) {
			return 0;
		}

		String[] stringNumberArray = split(text);

		return sum(stringNumberArray);
	}

	private static int sum(String[] stringNumberArray) {
		int sum = 0;
		for(String stringNumber : stringNumberArray){
			sum += parseInt(stringNumber);
		}
		return sum;
	}

	private static String[] split(String text) {
		return text.split(",");
	}

	private static int parseInt(String text) {
		return Integer.parseInt(text);
	}

	private static boolean isEmpty(String text) {
		return text == null || text.isEmpty();
	}
}
