package calculator;

import java.util.Objects;

public class Number {

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number valueOf(String str) {
        if (str == null || "".equals(str)) {
            return new Number(0);
        }
        return new Number(parseNumber(str));
    }

    public static int parseNumber(String str) {
        int number = Integer.parseInt(str);
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number target = (Number) o;
        return number == target.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public Number plus(Number number) {
        return new Number(this.number + number.number);
    }
}
