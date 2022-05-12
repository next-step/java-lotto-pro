package stringcalculator.vo;

import static stringcalculator.constants.ErrorMessageConstants.NON_POSITIVE_INTEGER_INPUT_ERROR;

import java.util.Objects;

public class PositiveNumber {

    private static final String POSITIVE_INTEGER_TYPE_REGEX = "\\d+";

    private int positiveNumber;

    private PositiveNumber() {
    }

    private PositiveNumber(int positiveNumber) {
        this.positiveNumber = positiveNumber;
    }

    public static PositiveNumber from(String input) {
        if (isNotPositiveInteger(input)) {
            throw new IllegalArgumentException(NON_POSITIVE_INTEGER_INPUT_ERROR);
        }
        return new PositiveNumber(Integer.parseInt(input));
    }

    private static boolean isNotPositiveInteger(String input) {
        return !input.matches(POSITIVE_INTEGER_TYPE_REGEX);
    }

    public int getPositiveNumber() {
        return positiveNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PositiveNumber that = (PositiveNumber) o;
        return positiveNumber == that.positiveNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positiveNumber);
    }
}
