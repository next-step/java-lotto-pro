package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PositiveNumbers {
    private static final Pattern ONLY_POSITIVE_NUMBER = Pattern.compile("[0-9]+");
    private static final String NON_POSITIVE_NUMBER_MESSAGE = "음수나 문자열은 사용할 수 없습니다.";

    private final List<Integer> numbers ;

    public PositiveNumbers(String[] numbers) {
        this.numbers = convertToPositiveNumbers(numbers);
    }

    private List<Integer> convertToPositiveNumbers(String[] numbers) {
        List<Integer> positiveNumbers = new ArrayList<>();
        for (String number : numbers) {
            validatePositiveNumber(number);
            positiveNumbers.add(Integer.parseInt(number));
        }
        return positiveNumbers;
    }

    private void validatePositiveNumber(String number) {
        if (!ONLY_POSITIVE_NUMBER.matcher(number).matches()) {
            throw new RuntimeException(NON_POSITIVE_NUMBER_MESSAGE);
        }
    }
}
