import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMIT_REGEX = "//(.)\n(.*)";
    private static final int ZERO = 0;

    private String expression;
    private Matcher customDelimitMatcher;
    private String[] numbers;

    public StringSplitter(String expression) {
        this.expression = expression;
        this.customDelimitMatcher = Pattern.compile(CUSTOM_DELIMIT_REGEX).matcher(expression);
        interpret();
    }

    private void interpret() {
        if (hasCustomDelimitPart()) {
            String customDelimiter = customDelimitMatcher.group(1);
            numbers = customDelimitMatcher.group(2).split(customDelimiter);
            return;
        }
        numbers = expression.split(DEFAULT_DELIMITER);
        return;
    }

    private boolean hasCustomDelimitPart() {
        return customDelimitMatcher.find();
    }

    public List<Integer> getNumbers() {
        List<Integer> numberList = new ArrayList<>();
        for (String numberString : numbers) {
            int number = Integer.parseInt(numberString);
            checkNagative(number);
            numberList.add(number);
        }
        return numberList;
    }

    private void checkNagative(int number) {
        if (number < ZERO) {
            throw new IllegalArgumentException("양수만 계산 가능합니다.");
        }
    }
}
