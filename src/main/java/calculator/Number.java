package calculator;

public class Number {
    private final int number;

    public Number(String value) {
        int number = getParsedNumber(value);
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 안됩니다.");
        }
    }

    private int getParsedNumber(String value) {
        if (!value.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("숫자형식이 아닙니다.");
        }
        return Integer.parseInt(value);
    }

    public int getNumber() {
        return number;
    }
}
