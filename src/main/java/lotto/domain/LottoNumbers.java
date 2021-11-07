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
    
    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchNumber(LottoNumbers winningNumbers) {
        return (int) numbers.stream()
                        .filter(number -> winningNumbers.getNumbers()
                        .contains(number))
                        .count();
    }

    @Override
    public String toString() {
        return Arrays.deepToString(numbers.toArray());
    }

}
