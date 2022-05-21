package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Count {
    private final int value;

    private Count(int value) {
        this.value = value;
    }

    public static Count from(int value) {
        return new Count(value);
    }

    public static Count from(String value) {
        if (!isNumber(value)) {
            throw new IllegalArgumentException("양수만 입력 가능합니다");
        }
        return new Count(Integer.parseInt(value));
    }

    private static boolean isNumber(String value) {
        return value.chars()
                .allMatch(Character::isDigit);
    }

    public int multiply(int value) {
        return this.value * value;
    }

    public <T> List<T> toList(Supplier<T> supplier) {
        return IntStream.range(0, value)
                .mapToObj(value -> supplier.get())
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count = (Count) o;
        return value == count.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
