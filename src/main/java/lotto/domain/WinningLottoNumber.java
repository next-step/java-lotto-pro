package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLottoNumber {
    public static final int WINNING_LOTTO_NUMBER_SIZE = 6;

    private final Set<Integer> numbers;
    private final Integer bonusNumber;

    public WinningLottoNumber(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = new HashSet<>(numbers);
        this.bonusNumber = bonusNumber;

        validateNumbers();
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void validateNumbers() {
        if (!LottoNumbers.ALL_NUMBERS.containsAll(this.numbers) || !LottoNumbers.ALL_NUMBERS.contains(this.bonusNumber)) {
            throw new IllegalArgumentException("당첨번호와 보너스번호는 1에서 45사이의 숫자여만 합니다.");
        }
        if (this.numbers.size() != WINNING_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("당첨번호는 중복되지 않는 6개의 숫자이여야 합니다.");
        }
        if (this.numbers.contains(this.bonusNumber)) {
            throw new IllegalArgumentException("보너스 당첨번호는 6개의 번호와 중복되지 않는 숫자이여야 합니다.");
        }
    }
}
