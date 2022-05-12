package calculator.number;

import calculator.common.Constants;
import calculator.common.ErrorMessage;
import calculator.parser.StringToIntegerParser;

public class PositiveNumber {
    private final String numberStr;

    public PositiveNumber(String numberStr) {
        matchesPositiveNumber(numberStr);
        this.numberStr = numberStr;
    }

    private void matchesPositiveNumber(String numberStr) {
        if (!numberStr.matches(Constants.POSITIVE_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_NUMBER);
        }
    }

    public int parseNumber() {
        StringToIntegerParser parser = new StringToIntegerParser(numberStr);
        return parser.parseInt();
    }
}
