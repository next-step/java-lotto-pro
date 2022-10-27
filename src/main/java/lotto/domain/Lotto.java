package lotto.domain;

import java.util.List;

public class Lotto {

    private final Numbers numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }

    public int getMatchCount(Lotto lotto) {
        return numbers.getMatchCount(lotto.numbers);
    }
}
