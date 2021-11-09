package lotto.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Number implements Comparable<Number> {
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 45;
    static final String NUMBER_RANGE_ERR_MSG = "로또는 " + MIN_NUMBER + "과 " + MAX_NUMBER + " 사이의 수만 가능합니다.";

    private static final Map<Integer, Number> VALUE_TO_NUMBER;

    private final int number;

    static {
        Map<Integer, Number> cache = new HashMap<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            cache.put(i, new Number(i));
        }
        VALUE_TO_NUMBER = Collections.unmodifiableMap(cache);
    }

    private Number(int number) {
        this.number = number;
    }

    public static Number ofValue(int number) {
        validate(number);
        return VALUE_TO_NUMBER.get(number);
    }

    private static void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERR_MSG);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Number other = (Number)obj;
        return number == other.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(Number other) {
        return Integer.compare(this.number, other.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
