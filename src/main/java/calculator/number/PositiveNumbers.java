package calculator.number;

import calculator.common.Constants;
import calculator.split.StringSplitter;

import java.util.ArrayList;
import java.util.List;

public class PositiveNumbers {
    private final List<PositiveNumber> positiveNumbers;

    private PositiveNumbers(List<PositiveNumber> positiveNumbers) {
        this.positiveNumbers = positiveNumbers;
    }

    public static PositiveNumbers newInstance(String text) {
        return new PositiveNumbers(addPositiveNumber(checkEmptyText(text)));
    }

    private static String checkEmptyText(String text) {
        if (text == null || text.isEmpty()) {
            return Constants.EMPTY_NUMBER;
        }
        return text;
    }

    private static List<PositiveNumber> addPositiveNumber(String text) {
        List<PositiveNumber> positiveNumbers = new ArrayList<>();
        StringSplitter stringSplitter = new StringSplitter(text);
        String[] splitNumbers = stringSplitter.splitText();
        for (String numberStr : splitNumbers) {
            positiveNumbers.add(new PositiveNumber(numberStr));
        }
        return positiveNumbers;
    }

    public List<PositiveNumber> getPositiveNumbers() {
        return positiveNumbers;
    }
}
