package lotto;

public class Lotto {

    public static final int MINIMUM_NUMBER = 1;

    private Lotto(){}

    public Lotto(int number) {
        validate(number);
    }

    private static void validate(int number) {
        validateMinimumNumber(number);
    }

    private static void validateMinimumNumber(int number) {
        if (number < MINIMUM_NUMBER) {
            throw new IllegalArgumentException(MINIMUM_NUMBER + "보다 작을 수 없습니다.");
        }
    }
}
