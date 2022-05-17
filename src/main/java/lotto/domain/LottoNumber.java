package lotto.domain;


import java.util.ArrayList;
import java.util.List;

public class LottoNumber {
    private final static int LOTTO_NUMBER_MIN_VALUE = 1;
    private final static int LOTTO_NUMBER_MAX_VALUE = 45;

    private final List<Integer> numbers;

    public LottoNumber() {
        this.numbers = new ArrayList<>();
        for (int i = LOTTO_NUMBER_MIN_VALUE; i <= LOTTO_NUMBER_MAX_VALUE; i++)
            this.numbers.add(i);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}

