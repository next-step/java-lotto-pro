package calculator;

public class PositiveNumber {
    private final int positiveNumber;
    private final String NUMBER_TYPE_REGEX = "^[0-9]*$";

    public PositiveNumber(String stringNumber) {
        validate(stringNumber);
        this.positiveNumber = Integer.parseInt(stringNumber);
    }

    public int getPositiveNumber() {
        return positiveNumber;
    }

    private void validate(String stringNumber) {
        validateNumberType(stringNumber);
    }

    private void validateNumberType(String input) {
        if (!input.matches(NUMBER_TYPE_REGEX)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
