package lotto.domain;

import java.util.List;

public class Lotto {
    private final LottoNumbers numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new LottoNumbers(numbers);
    }

    public int getCorrectCount(Lotto lotto) {
        return numbers.getCorrectCount(lotto.numbers);
    }

    @Override
    public String toString() {
        return "[" + numbers + "]";
    }
}
