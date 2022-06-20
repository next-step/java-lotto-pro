package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Number {
    private static final String LOTTERY_NUMBERS_WERE_OUT_OF_RANGE = "로또 번호 범위에 벗어난 숫자입니다.";

    private final int number;
    private static final Map<Integer, Number> numbers = new HashMap<>();

    static {
        for (int idx = Lottery.MINIMUM_NUMBER; idx <= Lottery.MAXIMUM_NUMBER; idx++) {
            numbers.put(idx, new Number(idx));
        }
    }

    public static Number of(final int number) {
        if (number < Lottery.MINIMUM_NUMBER || number > Lottery.MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(LOTTERY_NUMBERS_WERE_OUT_OF_RANGE);
        }
        return numbers.get(number);
    }

    public static Number of(final String number) {
        return of(readInt(number));
    }

    private static int readInt(String number) throws NumberFormatException {
        return Integer.parseInt(number);
    }

    private Number(int number) {
        this.number = number;
    }

    public int value() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }
}
