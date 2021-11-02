package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 문자열 덧셈 계산기 Product Code
 * @author Inmook,Jeong
 * @since 2021.11.02
 */
public class StringAddCalculator {

	private static final String DEFAULT_SEPARATOR = ",|:";
	private static final String CUSTOM_SEPARATOR_PATTERN = "//(.)\n(.*)";
	private static final String NUMERIC_PATTERN= "[0-9]+";

	public static int splitAndSum(String numberString) {
		if(isNullOrEmpty(numberString)) {
			return 0;
		}
		if(numberString.length() == 1) {
			return Integer.parseInt(numberString);
		}
		return calculate(numberString);
	}

	/**
	 * numberString이 null 또는 ""인지 확인
	 * @param numberString
	 * @return 맞으면 true
	 */
	private static boolean isNullOrEmpty(String numberString) {
		return (numberString == null || numberString.equals(""));
	}

	/**
	 * 구분자를 통해 구분된 값을 계산
	 * @param numberString
	 * @return 숫자를 모두 더한 값
	 */
	private static int calculate(String numberString) {
		int[] numbers = getNumbers(numberString);
		int sum = 0;
		for(int number : numbers) {
			sum += number;
		}
		return sum;
	}

	private static int[] getNumbers(String numberString) {
		String[] numberStrings = getNumberStrings(numberString);
		int[] numbers = new int[numberStrings.length];
		for(int i=0; i<numberStrings.length; i++) {
			numbers[i] = getNumber(numberStrings[i]);
		}
		return numbers;
	}

	private static int getNumber(String number) {
		Matcher numericMatcher = Pattern.compile(NUMERIC_PATTERN).matcher(number);
		if(numericMatcher.find() && Integer.parseInt(number) >= 0) {
			return Integer.parseInt(number);
		}
		throw new RuntimeException();
	}

	/**
	 * 구분자로 구분된 숫자 형태의 문자열 배열 가져오기
	 * @param numberString
	 * @return
	 */
	private static String[] getNumberStrings(String numberString) {
		Matcher m = Pattern.compile(CUSTOM_SEPARATOR_PATTERN).matcher(numberString);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}
		return numberString.split(DEFAULT_SEPARATOR);
	}
}
