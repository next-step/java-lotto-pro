package stringaddcalc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidator {
    private static final String BASIC_REGEX = ",|:";
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";
    private static final int STATIC_ONE = 1;
    private static final int STATIC_TWO = 2;
    String text;

    public NumberValidator(String text) {
        this.text = text;
    }

    public int checkNumberValidate() {
        int sum = 0;
        if (checkNull() == true) {
            return sum;
        }
        String[] numbers = checkRegex();
        Arrays.stream(numbers).forEach(number -> checkNegative(number));
        sum = MakeArraySum.getSum(numbers);
        return sum;
    }

    private void checkNegative(String s) {
        if (s.contains("-")) {
            throw new IndexOutOfBoundsException("0이상의 숫자만 입력할 수 있습니다. (음수 입력 불가)");
        }
    }

    private String[] checkRegex() {
        Matcher m = getMatcher();
        if (m.find()) {
            String customDelimiter = m.group(STATIC_ONE);
            String[] numbers = m.group(STATIC_TWO).split(customDelimiter);
            return numbers;
        }
        return text.split(BASIC_REGEX);
    }

    private Matcher getMatcher() {
        return Pattern.compile(CUSTOM_REGEX).matcher(text);
    }

    private boolean checkNull() {
        return text == null || text.equals("");
    }
}
