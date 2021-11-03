package step2;

import java.util.Arrays;

public class StringAddCalculator {
	public static int splitAndSum(String string) {
		if (validateNullOrBlank(string)) {
			return 0;
		}
		return sum(splitStringToIntArray(string));
	}

	private static boolean validateNullOrBlank(String string) {
		if (string == null || string.equals("")) {
			return true;
		}
		return false;
	}

	private static int[] splitStringToIntArray(String string) {
		int[] intArray;
		try {
			 intArray = Arrays.stream(string.split(",")).mapToInt(Integer::parseInt).toArray();
		} catch (NumberFormatException e) {
			throw new RuntimeException("구분자 혹은 입력 값을 다시 한번 확인해주세요.");
		}
		return intArray;
	}

	private static int sum(int[] intArray) {
		return Arrays.stream(intArray).sum();
	}
}
