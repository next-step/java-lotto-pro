package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoNumbers {
    private final List<Integer> numbers;

    private LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static LottoNumbers valueOf(List<Integer> numbers) {
        return new LottoNumbers(numbers);
    }

    public int getSize() {
        return numbers.size();
    }

    public int countMatchNumber(List<Integer> winningNumbers) {
        return (int) numbers.stream().filter(number -> winningNumbers.contains(number)).count();
    }

    @Override
    public String toString() {
        return Arrays.deepToString(numbers.toArray());
    }

}
