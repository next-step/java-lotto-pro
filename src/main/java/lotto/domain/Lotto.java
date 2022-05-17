package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.exception.ExceptionType;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumberSize(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validateLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(
                ExceptionType.INVALID_LOTTO_NUMBER_SIZE.getMessage());
        }
    }

    public int getWinningOfNumbersCount(WinningNumbers winningNumbers) {
        return (int) winningNumbers.getWinningNumbers().stream().filter(numbers::contains).count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
