import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String CUSTOM_DELIMITER_NOT_SINGLE_ERROR_MESSAGE = "[ERROR] 커스텀 구분자는 한자리 문자여야 합니다.";
	private static final String CUSTOM_DELIMITER_NUMBER_ERROR_MESSAGE = "[ERROR] 커스텀 구분자는 숫자여야 합니다.";
	private static final String CUSTOM_DELIMITER_EMPTY_ERROR_MESSAGE = "[ERROR] 커스텀 구분자가 빈값입니다.";
	private static final String NOT_DIGIT_ERROR_MESSAGE = "[ERROR] 구분자 사이에는 숫자만 입력해주세요.";
	private static final String NUMBER_INPUT_NEGATIVE_VALUE_ERROR_MESSAGE = "[ERROR] 0이상의 숫자만 입력해주세요.";
	private static final String BASIC_DELIMITERS = ":|,";
	private static final String CUSTOM_DELIMIERS_PATTERN = "//(.*)\n(.*)";
	private static final int SINGLE_LETTER_LENGTH = 1;
	private static final int SPLIT_CUSTOM_DELIMITER_INDEX = 1;
	private static final int SPLIT_NUMBER_TEXT_INDEX = 2;

	public static int splitAndSum(String text) {
		if (isTextNullOrEmpty(text)) {
			return 0;
		}
		String[] splitedText = splitText(text);
		int[] numbers = convertToNumbers(splitedText);
		return sumNumbers(numbers);
	}

	private static boolean isTextNullOrEmpty(String text) {
		if (text == null || text.isEmpty()) {
			return true;
		}
		return false;
	}

	private static String[] splitText(String text) {
		Matcher m = Pattern.compile(CUSTOM_DELIMIERS_PATTERN).matcher(text);
		if (hasCustomDelimiter(m)) {
			String customDelimiter = m.group(SPLIT_CUSTOM_DELIMITER_INDEX);
			return splitWithDelimiters(m.group(SPLIT_NUMBER_TEXT_INDEX), getDelimitersWithCustom(customDelimiter));
		}
		return splitWithDelimiters(text, BASIC_DELIMITERS);
	}

	private static boolean hasCustomDelimiter(Matcher m) {
		if (m.find()) {
			return true;
		}
		return false;
	}

	private static String[] splitWithDelimiters(String text, String basicDelimiters) {
		return text.split(basicDelimiters);
	}

	private static String getDelimitersWithCustom(String customDelimiter) {
		validateCustomDelimiter(customDelimiter);
		return String.join("|", BASIC_DELIMITERS, customDelimiter);
	}

	private static void validateCustomDelimiter(String customDelimiter) {
		validateIsEmptyDelimiter(customDelimiter);
		validateSingleLetter(customDelimiter);
		validateNotNumber(customDelimiter);
	}

	private static void validateIsEmptyDelimiter(String customDelimiter) {
		if (customDelimiter.isEmpty()) {
			throw new RuntimeException(CUSTOM_DELIMITER_EMPTY_ERROR_MESSAGE);
		}
	}

	private static void validateSingleLetter(String customDelimiter) {
		if (customDelimiter.length() > SINGLE_LETTER_LENGTH) {
			throw new RuntimeException(CUSTOM_DELIMITER_NOT_SINGLE_ERROR_MESSAGE);
		}
	}

	private static int[] convertToNumbers(String[] splitedText) {
		List<Integer> numbers = new ArrayList<>();
		for (String letter : splitedText) {
			int number = convertToInteger(letter);
			validateNotNegativeInteger(number);
			numbers.add(number);
		}
		return numbers.stream().mapToInt(number -> number).toArray();
	}

	private static Integer convertToInteger(String letter) {
		try {
			int number = Integer.parseInt(letter);
			return number;
		} catch (NumberFormatException ex) {
			throw new RuntimeException(NOT_DIGIT_ERROR_MESSAGE);
		}
	}

	// validateSingleLetter에서 single letter인걸 검사한 후이지만 charAt(0)으로 명시적으로 써도 괜찮을까요?
	private static void validateNotNumber(String customDelimiter) {
		if (Character.isDigit(customDelimiter.charAt(0))) {
			throw new RuntimeException(CUSTOM_DELIMITER_NUMBER_ERROR_MESSAGE);
		}
	}

	private static void validateNotNegativeInteger(int number) {
		if (number < 0) {
			throw new RuntimeException(NUMBER_INPUT_NEGATIVE_VALUE_ERROR_MESSAGE);
		}
	}

	private static int sumNumbers(int[] numbers) {
		int sum = 0;
		for (int num : numbers) {
			sum += num;
		}
		return sum;
	}
}
