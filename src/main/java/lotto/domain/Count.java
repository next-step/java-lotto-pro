package lotto.domain;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Count {
    private final int value;

    public Count(int value) {
        this.value = value;
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
    public String toString() {
        return String.valueOf(value);
    }
}
