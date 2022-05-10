package common;

public class PositiveNumber {
    private final String NUMBER_CHECK_REGEX = "-?\\d+";

    public final Integer value;

    public PositiveNumber(Integer value) {
        checkPositiveNumber(value);
        this.value = value;
    }

    public PositiveNumber(String value) {
        checkValidNumberByString(value);
        Integer convertValue = Integer.parseInt(value);
        checkPositiveNumber(convertValue);
        this.value = convertValue;
    }

    private void checkPositiveNumber(Integer value) {
        if (value < 0) {
            throw new RuntimeException("양수만 허용됩니다.");
        }
    }

    private void checkValidNumberByString(String value) {
        if (!value.matches(NUMBER_CHECK_REGEX)) {
            throw new RuntimeException("숫자만 허용됩니다.");
        }
    }
}
