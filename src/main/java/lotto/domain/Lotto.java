package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public int getWinningOfNumbersCount(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
            .filter(numbers::contains)
            .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
