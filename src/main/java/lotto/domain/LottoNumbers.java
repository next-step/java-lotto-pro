package lotto.domain;

import lotto.utils.LottoValidationUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
    public static final int LOTTO_SIZE = 6;
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;
    private final Set<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = new HashSet<>(numbers);
        validateNumbers();
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public boolean match(Integer number) {
        return this.numbers.contains(number);
    }

    public WinningRank matchWinningNumbers(WinningLottoNumber winningNumbers) {
        int matchCount = 0;
        for (Integer winningNumber : winningNumbers.getNumbers()) {
            matchCount += matchWinningNumber(winningNumber);
        }
        return WinningRank.of(matchCount, match(winningNumbers.getBonusNumber()));
    }

    private Integer matchWinningNumber(Integer winningNumber) {
        if (match(winningNumber)) {
            return 1;
        }
        return 0;
    }

    private void validateNumbers() {
        for (Integer number : numbers) {
            LottoValidationUtils.validateNumberRange(number);
        }

        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않는 6개의 숫자이여야 합니다.");
        }
    }
}
