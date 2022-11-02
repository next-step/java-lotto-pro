package lotto;

public class Lotto {

    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;

    private Lotto(){}

    public Lotto(int number) {
        validate(number);
    }

    private static void validate(int number) {
        validateMinimumNumber(number);
        validateMaximumNumber(number);
    }

    private static void validateMinimumNumber(int number) {
        if (number < MINIMUM_NUMBER) {
            throw new IllegalArgumentException(MINIMUM_NUMBER + "보다 작을 수 없습니다.");
        }
    }

    private static void validateMaximumNumber(int number) {
        if (number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(MAXIMUM_NUMBER + "보다 클 수 없습니다.");
        }
    }
}
