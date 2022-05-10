package level1.stringCaluator.calculator;

import common.PositiveNumbers;
import level1.stringCaluator.until.StringParser;

public class StringCalculator {
    private final PositiveNumbers positiveNumbers;

    public StringCalculator(String input) {
        this.positiveNumbers = new PositiveNumbers(StringParser.parseAndSplit(input));
    }

    public int sum() {
        return this.positiveNumbers.sum();
    }
}
