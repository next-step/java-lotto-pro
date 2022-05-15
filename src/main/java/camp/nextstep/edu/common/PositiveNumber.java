package camp.nextstep.edu.common;

public class PositiveNumber {
    private static final String NUMBER_CHECK_REGEX = "-?\\d+";

    private final long value;

    public PositiveNumber(int value) {
        checkPositiveNumber(value);

        this.value = value;
    }

    public PositiveNumber(long value) {
        checkPositiveNumber(value);
        this.value = value;
    }

    public PositiveNumber(String value) {
        String convertEmptyOrNull = convertEmptyOrNullToZero(value);

        checkValidNumberByString(convertEmptyOrNull);

        long convertValue = Long.parseLong(convertEmptyOrNull);
        checkPositiveNumber(convertValue);

        this.value = convertValue;
    }

    public long getValue() {
        return this.value;
    }

    private void checkPositiveNumber(long value) {
        if (value < 0) {
            throw new RuntimeException("양수만 허용됩니다.");
        }
    }

    private void checkValidNumberByString(String value) {
        if (!value.matches(NUMBER_CHECK_REGEX)) {
            throw new RuntimeException("숫자만 허용됩니다.");
        }
    }

    private String convertEmptyOrNullToZero(String value) {
        if (value.isEmpty()) {
            return "0";
        }
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
