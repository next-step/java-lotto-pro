package lotto.domain;

import java.util.List;

public class Lotto {

    private final Numbers numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }

    protected boolean contains(Number bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    protected int getMatchCount(Lotto lotto) {
        return numbers.getMatchCount(lotto.numbers);
    }

    @Override
    public String toString() {
        return "[" + numbers + "]";
    }
}
