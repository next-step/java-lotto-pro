package lotto.model;

import static lotto.constants.LottoConstant.MAX_NUMBER;
import static lotto.constants.LottoConstant.MIN_NUMBER;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Number {
    private static final Map<Integer, Number> NUMBER_CACHE;
    private final int number;

    static {
        NUMBER_CACHE = new HashMap<>();
    }

    private Number(int number) {
        this.number = number;
    }

    public static Number of(int number) {
        validateRange(number);
        if (isNotContainCache(number)) {
            NUMBER_CACHE.put(number, new Number(number));
        }
        return NUMBER_CACHE.get(number);
    }

    private static boolean isNotContainCache(int number) {
        return !NUMBER_CACHE.containsKey(number);
    }

    private static void validateRange(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException("로또 숫자 범위를 벗어났습니다.");
        }
    }

    private static boolean isOutOfRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
