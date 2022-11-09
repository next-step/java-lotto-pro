package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final List<Integer> ALL_NUMBERS = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .boxed()
            .collect(Collectors.toList());
    private final int value;

    public LottoNumber(int value) {
        if (isNotValid(value)) {
            throw new IllegalArgumentException("숫자는 1에서 45 사이여야 합니다. value=[" + value + "]");
        }
        this.value = value;
    }

    public static List<Integer> allNumbers() {
        return new ArrayList<>(ALL_NUMBERS);
    }

    public static boolean isNotValid(final int value) {
        return !(MIN_NUMBER <= value && value <= MAX_NUMBER);
    }

    public int toInt() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
