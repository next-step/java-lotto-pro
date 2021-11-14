import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String COMMA_OR_COLON = ",|:";
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int TEXT_INDEX = 2;
    private static final String NO_MINUS_ERROR_MESSAGE = "음수 입력 불가능 number: ";

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        return sum(parseToIntArray(split(text)));
    }

    private static String[] split(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_INDEX);
            return m.group(TEXT_INDEX).split(customDelimiter);
        }
        return text.split(COMMA_OR_COLON);
    }

    private static int[] parseToIntArray(String[] textNumbers) {
        int[] numbers = new int[textNumbers.length];

        for (int i = 0; i < textNumbers.length; i++) {
            numbers[i] = parseToInt(textNumbers[i]);
        }

        return numbers;
    }

    private static int parseToInt(String textNumber) {
        int number = Integer.parseInt(textNumber);

        if (number < 0) {
            throw new IllegalArgumentException(NO_MINUS_ERROR_MESSAGE + number);
        }

        return number;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

}
