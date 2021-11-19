package lotto.domain;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;

public class Ball implements Comparable<Ball> {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private static final Map<Integer, Ball> numberToBall = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
        .mapToObj(Ball::new)
        .collect(Collectors.toMap(Ball::getNumber, Function.identity()));

    private final int number;

    private Ball(int number) {
        this.number = number;
    }

    public static Ball of(int number) {
        validateNumberInRange(number);
        return numberToBall.get(number);
    }

    private static void validateNumberInRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new LottoException(LottoErrorCode.INVALID_BALL);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ball)) {
            return false;
        }
        Ball that = (Ball)o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(Ball that) {
        return Integer.compare(this.number, that.number);
    }
}
