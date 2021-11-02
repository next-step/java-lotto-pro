import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String basicDelimiters = ":|,";
	private static final int SPLIT_CUSTOM_DELIMITER_INDEX = 1;
	private static final int SPLIT_NUMBER_TEXT_INDEX = 2;

	public static int splitAndSum(String text) {
		if (isTextNullOrEmpty(text)) {
			return 0;
		}
		String[] splitedText = splitText(text);
		int[] numbers = converToNumbers(splitedText);
		return sumNumbers(numbers);
	}

	private static boolean isTextNullOrEmpty(String text) {
		if (text == null || text.isEmpty()) {
			return true;
		}
		return false;
	}

	private static String[] splitText(String text) {
		Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(text);
		if (hasCustomDelimiter(m)) {
			String customDelimiter = m.group(SPLIT_CUSTOM_DELIMITER_INDEX);
			return splitWithDelimiters(m.group(SPLIT_NUMBER_TEXT_INDEX), getDelimitersWithCustom(customDelimiter));
		}
		return splitWithDelimiters(text, basicDelimiters);
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
		return String.join("|", basicDelimiters, customDelimiter);
	}

	private static int[] converToNumbers(String[] splitedText) {
		List<Integer> numbers = new ArrayList<>();
		for (String letter : splitedText) {
			int number = converToInteger(letter);
			numbers.add(number);
		}
		return numbers.stream().mapToInt(number -> number).toArray();
	}

	private static Integer converToInteger(String letter) {
		try {
			int number = Integer.parseInt(letter);
			return number;
		} catch (NumberFormatException ex) {
			throw new RuntimeException();
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
