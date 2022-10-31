package study;

import static study.StringAddCalculator.ZERO;

import java.util.Objects;

public class Number {
    private final int number;

    Number(int number) {
        this.number = number;
    }

    public static Number validator(String text) {
        if (text == null || text.isEmpty()) {
            return new Number(ZERO);
        }
        return new Number(stringToInt(text));
    }

    public static int stringToInt(String text) {
        int number = Integer.parseInt(text);
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    public Number add(Number number) {
        return new Number(this.number + number.number);
    }

    public int toInt() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number target = (Number) o;
        return number == target.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
