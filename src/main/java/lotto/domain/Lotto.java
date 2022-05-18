package lotto.domain;

import static lotto.constants.LottoConstants.MAX;
import static lotto.constants.LottoConstants.MIN;

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

    public static boolean isLottoNumberSize(int number) {
        return number > MAX || number < MIN;
    }

    private void validateLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(
                ExceptionType.INVALID_LOTTO_NUMBER_SIZE.getMessage());
        }
    }

    public int getWinningOfNumbersCount(WinningNumbers winningNumbers) {
        int countOfMatch = (int) winningNumbers.getWinningNumbers().stream()
            .filter(numbers::contains).count();
        int bonusCount = winningNumbers.isContainsBonusNumber(this) ? 1 : 0;

        return countOfMatch + bonusCount;
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
