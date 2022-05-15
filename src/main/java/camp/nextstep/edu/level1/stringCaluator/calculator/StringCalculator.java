package camp.nextstep.edu.level1.stringCaluator.calculator;

import camp.nextstep.edu.common.PositiveNumbers;
import camp.nextstep.edu.until.StringParser;

public class StringCalculator {
    private final PositiveNumbers positiveNumbers;

    public StringCalculator(String input) {
        this.positiveNumbers = new PositiveNumbers(StringParser.parseAndSplit(input), true);
    }

    public long sum() {
        return this.positiveNumbers.sum();
    }
}
