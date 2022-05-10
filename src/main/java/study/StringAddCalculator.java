package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int DELIMITER = 1;
    private static final int NUMBER_WORDS = 2;
    private static final String CUSTOM_REGEX = "//(.)\\n(.*)";
    private static final String COMMA_OR_COLON_REGEX = ",|:";

    private static final Pattern customPattern = Pattern.compile(CUSTOM_REGEX);

    public static int splitAndSum(String numberWords) {
        int sum = 0;
        if (isNullOrEmpty(numberWords)) {
            return sum;
        }
        String[] splitNumbers = splitNumberWords(numberWords);
        return sumNumbers(sum, splitNumbers);
    }

    private static boolean isNullOrEmpty(String numberWords) {
        return numberWords == null || numberWords.isEmpty();
    }

    private static String[] splitNumberWords(String numberWords) {
        Matcher matcher = customPattern.matcher(numberWords);
        if (matcher.find()) {
            String customDelimiter = matcher.group(DELIMITER);
            return matcher.group(NUMBER_WORDS).split(customDelimiter);
        }
        return numberWords.split(COMMA_OR_COLON_REGEX);
    }

    private static int sumNumbers(int sum, String[] splitNumbers) {
        for (String number : splitNumbers) {
            sum += wordToNumber(number);
        }
        return sum;
    }

    private static int wordToNumber(String number) {
        if (number.matches("\\p{Digit}")) {
            return Integer.parseInt(number);
        }
        throw new IllegalArgumentException("[ERROR] 0~9 사이의 숫자가 아닙니다.");
    }

    private StringAddCalculator() {
        throw new IllegalStateException("Utility class");
    }
}
