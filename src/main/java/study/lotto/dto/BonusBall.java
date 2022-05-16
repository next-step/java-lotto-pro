package study.lotto.dto;

public class BonusBall {
    private static final int MINIMUM_BONUS_NUBMER = 1;
    private static final int MAXIMUM_BONUS_NUBMER = 45;

    private final int value;

    public BonusBall(String stringValue) {
        this.value = validate(stringValue);
    }

    public int get() {
        return value;
    }

    private int validate(String stringValue) {
        int parsedNumber = parseNumber(stringValue);

        validateMinimumNumber(parsedNumber);
        validateMaximumNumber(parsedNumber);

        return parsedNumber;
    }

    private int parseNumber(String stringValue) {
        return Integer.parseInt(stringValue);
    }

    private void validateMinimumNumber(int number) {
        if (number < MINIMUM_BONUS_NUBMER) {
            throw new IllegalArgumentException(String.format("보너스볼은 %d보다 커야 합니다.", MINIMUM_BONUS_NUBMER));
        }
    }

    private void validateMaximumNumber(int number) {
        if (number > MAXIMUM_BONUS_NUBMER) {
            throw new IllegalArgumentException(String.format("보너스볼은 %d보다 작아야 합니다.", MAXIMUM_BONUS_NUBMER));
        }
    }
}
