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

    public int getNumber() {
        int sum = 0;
        if (checkNull() == true) {
            return sum;
        }
        String[] numbers = checkRegex();
        for (int i = 0; i < numbers.length; i++) {
            checkNegative(numbers[i]);
        }
        sum = MakeArraySum.getSum(numbers);
        return sum;
    }

    private void checkNegative(String s) {
        if (s.contains("-")) {
            throw new RuntimeException("0이상의 숫자만 입력할 수 있습니다. (음수 입력 불가)");
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
        if (text == null || text.equals("")) {
            return true;
        }
        return false;
    }
}
