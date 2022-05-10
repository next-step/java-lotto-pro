import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidator {
    private static final String CUSTOM_REGEX = "//(.)\n(.*)";
    private static MakeArraySum makeArraySum = new MakeArraySum();
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
        sum = makeArraySum.getSum(numbers);
        return sum;
    }

    private void checkNegative(String s) {
        if (s.contains("-")) {
            throw new RuntimeException();
        }
    }

    private String[] checkRegex() {
        Matcher m = getMatcher();
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] numbers = m.group(2).split(customDelimiter);
            return numbers;
        }
        return text.split(",|:");
    }

    private Matcher getMatcher() {
        Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(text);
        return m;
    }

    private boolean checkNull() {
        if (text == null || text.equals("")) {
            return true;
        }
        return false;
    }
}
