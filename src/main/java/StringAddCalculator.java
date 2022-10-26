import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DIVIDER = ",|:";
    private static final String AND_DIVIDER = "|";
    private static final String REGEX = "//(.)\n(.*)";
    private static final Pattern PATTERN_COMPILE = Pattern.compile(REGEX);
    private static final String MINUS_EXCEPTION_MESSAGE = "음수는 입력이 불가능해요";
    private static final int EMPTY_RESULT = 0;
    private static final int MATCH_FIRST_GROUP = 1;
    private static final int MATCH_SECOND_GROUP = 2;
    private static final int VALID_CHECK_STANDARD_NUMBER = 0;

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return EMPTY_RESULT;
        }

        return calculateResult(input);
    }

    private static int calculateResult(String input) {
        Matcher matchResult = PATTERN_COMPILE.matcher(input);
        String delimiter = DIVIDER;
        String value = input;

        if (matchResult.find()) {
            delimiter = delimiter + AND_DIVIDER + matchResult.group(MATCH_FIRST_GROUP);
            value = matchResult.group(MATCH_SECOND_GROUP);
        }
        
        String[] splitNumber = value.split(delimiter);

        return getSum(splitNumber);
    }

    private static int getSum(String[] splitNumber) {
        int answer = 0;
        for (String stringNumber : splitNumber) {
            int number = Integer.parseInt(stringNumber);
            validCheckMinus(number);
            answer += number;
        }

        return answer;
    }

    private static void validCheckMinus(int number) {
        if (number < VALID_CHECK_STANDARD_NUMBER) {
            throw new RuntimeException(MINUS_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }
}
