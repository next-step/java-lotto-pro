package lotto.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import lotto.exception.BadRequestException;

public class Number implements Comparable<Number> {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    static final String NUMBER_RANGE_ERR_MSG = "로또는 " + MIN_NUMBER + "과 " + MAX_NUMBER + " 사이의 수만 가능합니다.";

    private static final Map<Integer, Number> VALUE_TO_NUMBER;

    static {
        Map<Integer, Number> map = new HashMap<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            map.put(i, new Number(i));
        }
        VALUE_TO_NUMBER = Collections.unmodifiableMap(map);
    }

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number ofValue(int number) {
        validate(number);
        return VALUE_TO_NUMBER.get(number);
    }

    private static void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new BadRequestException(NUMBER_RANGE_ERR_MSG);
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
