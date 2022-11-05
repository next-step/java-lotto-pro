package common.vo;

import java.util.Objects;

public class Number {

    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;

    private int number;

    private Number(){}

    public Number(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        validateMinimumNumber(number);
        validateMaximumNumber(number);
    }

    private void validateMinimumNumber(int number) {
        if (number < MINIMUM_NUMBER) {
            throw new IllegalArgumentException(MINIMUM_NUMBER + "보다 작을 수 없습니다.");
        }
    }

    private void validateMaximumNumber(int number) {
        if (number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(MAXIMUM_NUMBER + "보다 클 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return this.number == number.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int getNumber() {
        return this.number;
    }
}
