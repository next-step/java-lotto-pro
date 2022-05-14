package calculator;

import calculator.utils.Splitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PositiveNumbers {
    private final List<PositiveNumber> positiveNumbers;
    private final HashSet<String> ZERO_CONDITIONS = new HashSet<>(Arrays.asList("", null));
    private final String DEFAULT_VALUE = "0";

    public PositiveNumbers(String input) {
        this.positiveNumbers = new ArrayList<>();
        initializePositiveNumbers(input);
    }

    private void initializePositiveNumbers(String input) {
        if (ZERO_CONDITIONS.contains(input)) {
            this.positiveNumbers.add(new PositiveNumber(DEFAULT_VALUE));
            return;
        }

        for (String splitString : Splitter.splitString(input)) {
            this.positiveNumbers.add(new PositiveNumber(splitString));
        }
    }

    public int sum() {
        int accNumbers = 0;
        for (PositiveNumber positiveNumber : positiveNumbers) {
            accNumbers += positiveNumber.getPositiveNumber();
        }
        return accNumbers;
    }
}
