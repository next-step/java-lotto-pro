package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utlis.StringUtils.isNullOrEmpty;
import static utlis.StringUtils.toInt;

public class StringAddCalculator {

    private static final int ZERO_NUMBER = 0;
    private static final String DEFAULT_SEPARATORS = ",|:";
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int CUSTOM_INPUT_GROUP = 2;
    private static final String ERROR_MESSAGE_NOT_POSITIVE_NUMBER = "문자열 계산기에 음수는 올 수 없습니다. [%d]";


    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return ZERO_NUMBER;
        }
        String[] splitText = splitText(text);
        return sumSplitText(splitText);
    }

    private static int sumSplitText(String[] splitText) {
        int sum = 0;
        for (String text : splitText) {
            sum += convertPositiveNumber(text);
        }
        return sum;
    }

    private static int convertPositiveNumber(String text) {
        int number = toInt(text);
        if (number < ZERO_NUMBER) {
            throw new RuntimeException(String.format(ERROR_MESSAGE_NOT_POSITIVE_NUMBER, number));
        }
        return number;
    }

    private static String[] splitText(String text) {
        Matcher matcher = CUSTOM_DELIMITER.matcher(text);
        String delimiter = DEFAULT_SEPARATORS;
        if (matcher.find()) {
            delimiter = delimiter + "|" + matcher.group(CUSTOM_DELIMITER_GROUP);
            text = matcher.group(CUSTOM_INPUT_GROUP);
        }
        return text.split(delimiter);
    }

}
