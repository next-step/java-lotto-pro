package lotto.domain;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Number {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final Map<Integer, Number> numberMap = IntStream
            .rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toMap(Function.identity(), Number::new));

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number from(int number) {
        validNumber(number);
        return numberMap.get(number);
    }

    private static void validNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("1에서 45 사이의 숫자만 가능합니다.");
        }
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
