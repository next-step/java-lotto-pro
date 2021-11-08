package lotto.domain;

import lotto.exception.LottoNumberOutOfRangeException;
import lotto.exception.LottoNumberSizeException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class Number implements Comparable<Number> {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private static final Map<Integer, Number> lottoNumbers = new HashMap<>();

    static {
        IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .forEach(i -> lottoNumbers.put(i, new Number(i)));
    }

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number of(int number) {
        validateNumberRange(number);
        return lottoNumbers.get(number);
    }

    private static void validateNumberRange(int randomNumber) {
        if (randomNumber > MAX_NUMBER) {
            throw new LottoNumberOutOfRangeException("[ERROR] 로또 번호의 최대 크기 : " + MAX_NUMBER);
        }
        if (randomNumber < MIN_NUMBER) {
            throw new LottoNumberOutOfRangeException("[ERROR] 로또 번호의 최소 크기 : " + MIN_NUMBER);
        }
    }

    @Override
    public int compareTo(Number o) {
        if (this.number > o.number) {
            return 1;
        }
        if (this.number < o.number) {
            return -1;
        }
        return 0;
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

    public int getNumber() {
        return number;
    }
}
