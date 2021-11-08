package stringaddcalculator;

public class NaturalNumber {

    private static final int LOWER_BOUND = 0;
    private static final String NATURAL_NUMBER_SHOULD_NOT_BE_NEGATIVE = "음수를 입력할 수 없습니다.";

    private final int value;

    public NaturalNumber(int value) {
        naturalNumberShouldNotBeNegative(value);
        this.value = value;
    }

    public NaturalNumber(String number) {
        this(Integer.parseInt(number));
    }

    private void naturalNumberShouldNotBeNegative(final int number) {
        if (number < LOWER_BOUND) {
            throw new IllegalArgumentException(NATURAL_NUMBER_SHOULD_NOT_BE_NEGATIVE);
        }
    }

    public int getValue() {
        return this.value;
    }
}
