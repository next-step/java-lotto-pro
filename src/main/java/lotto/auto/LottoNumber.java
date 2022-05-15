package lotto.auto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumber {
    private final static int LOTTO_NUMBER_SIZE_VALUE = 6;

    private List<Integer> numbers;

    public LottoNumber() {
        this.numbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_SIZE_VALUE; i++) {
            this.numbers.add(i+1);
        }
    }

    public int lottoNumberCount() {
        return LOTTO_NUMBER_SIZE_VALUE;
    }

    public void sortLottoNumber() {
        this.numbers= this.numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }

    public int winningCount(List<Integer> answerNumberList) {
        return 0;
    }
}

