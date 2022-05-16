package lotto.domain;

import lotto.utils.LottoValidationUtils;

import java.util.List;
import java.util.Set;

public class WinningLottoNumber {

    private final LottoNumbers numbers;
    private final Integer bonusNumber;

    public WinningLottoNumber(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = new LottoNumbers(numbers);
        this.bonusNumber = bonusNumber;

        validateNumbers();
    }

    public Set<Integer> getNumbers() {
        return numbers.getNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void validateNumbers() {
        LottoValidationUtils.validateNumberRange(bonusNumber);

        if (numbers.match(this.bonusNumber)) {
            throw new IllegalArgumentException("보너스 당첨번호는 6개의 번호와 중복되지 않는 숫자이여야 합니다.");
        }
    }
}
