package lotto;

public class Number {

    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;

    private final int number;

    public Number(final int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(final int number) {
        if (number < LOWER_BOUND || number > UPPER_BOUND) {
            throw new IllegalArgumentException(
                "로또 숫자는 " + LOWER_BOUND + "보다 크거나 " + UPPER_BOUND + "보다 작아야합니다."
            );
        }
    }
}
