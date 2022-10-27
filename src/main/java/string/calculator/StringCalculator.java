package string.calculator;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class StringCalculator {
    private final String input;

    public StringCalculator(String input) {
        this.input = input;
    }

    public int calculate() {
        if (isEmpty(input)) {
            return 0;
        }
        return 0;
    }
}
