package lotto.domain.winning;

import lotto.domain.lotto.LottoNumber;

import java.util.Set;

public class BonusNumber {
    private static final int MIN_BONUS_BOUND = 1;
    private static final int MAX_BONUS_BOUND = 45;

    private final int bonusNumber;

    public BonusNumber(WinningNumbers winningNumbers, int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplication(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < MIN_BONUS_BOUND || bonusNumber > MAX_BONUS_BOUND) {
            throw new IllegalArgumentException("보너스 번호는 1 ~ 45 까지 입니다.");
        }
    }

    private void validateDuplication(WinningNumbers winningNumbers, int bonusNumber) {
        if (winningNumbers.isContains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    public boolean isMatch(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.getLottoNumber() == bonusNumber);
    }
}
