package lotto.domain;


import java.util.HashSet;
import java.util.Set;

public class LottoNumber {
    private final static int LOTTO_NUMBER_MIN_VALUE = 1;
    private final static int LOTTO_NUMBER_MAX_VALUE = 45;

    public final static Set<Integer> numbers = generateNumbers();

    private static Set<Integer> generateNumbers() {
        Set<Integer> numbers = new HashSet<>();
        for (int i = LOTTO_NUMBER_MIN_VALUE; i <= LOTTO_NUMBER_MAX_VALUE; i++)
            numbers.add(i);

        return numbers;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}

