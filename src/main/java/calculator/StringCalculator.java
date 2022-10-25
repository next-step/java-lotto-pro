package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";

    public static final int CUSTOM_DELIMITER_INDEX = 1;
    public static final int CUSTOM_CALCULATE_INDEX = 2;
    public static final String CUSTOM_CALCULATOR_REGEX = "//(.)\n(.*)";
    public static final String ONLY_NUMBER_REGEX = "^\\d*$";


    public static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    public static boolean isNull(String input) {
        return input == null;
    }

    private static boolean validateNullOrEmpty(String input) {
        return isNull(input) || isEmpty(input);
    }

    public static int addOperation(String input) {
        if(validateNullOrEmpty(input)){
            return 0;
        }

        Matcher matcher = Pattern.compile(CUSTOM_CALCULATOR_REGEX).matcher(input);
        if(matcher.find()){
           return addByDelimiter(matcher.group(CUSTOM_CALCULATE_INDEX), matcher.group(CUSTOM_DELIMITER_INDEX));
        }

        return addByDelimiter(input, DEFAULT_DELIMITER);
    }

    private static int addByDelimiter(String input, String delimiter) {
        AtomicInteger result = new AtomicInteger();
        List<String> numbers = Arrays.asList(input.split(delimiter));
        for (String number : numbers) {
            validateNumber(number);
            result.addAndGet(Integer.parseInt(number));
        }

        return result.get();
    }

    public static void validateNumber(String input) {
        if(!Pattern.matches(ONLY_NUMBER_REGEX, input)){
            throw new RuntimeException("숫자 이외의 문자가 포함되어 있습니다.");
        }
    }
}
