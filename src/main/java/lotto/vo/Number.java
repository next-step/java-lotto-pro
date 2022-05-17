package lotto.vo;

import java.util.Objects;

public class Number {
    private static final String LOTTERY_NUMBERS_WERE_OUT_OF_RANGE = "로또 번호 범위에 벗어난 숫자입니다.";

    private int number;

    public Number(final int number) {
        if (number < Lottery.MINIMUM_NUMBER || number > Lottery.MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(LOTTERY_NUMBERS_WERE_OUT_OF_RANGE);
        }
        this.number = number;
    }

    public Number(final String number) {
        this(readInt(number));
    }

    private static int readInt(String number) throws NumberFormatException {
        return Integer.parseInt(number);
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
