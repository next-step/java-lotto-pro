package lotto.domain.winning;

import lotto.domain.lotto.LottoNumber;

import java.util.Set;

public class BonusNumber {

    private final LottoNumber bonusNumber;

    public BonusNumber(WinningNumbers winningNumbers, int bonusNumber) {
        validateDuplication(winningNumbers, bonusNumber);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private void validateDuplication(WinningNumbers winningNumbers, int bonusNumber) {
        if (winningNumbers.isContains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    public boolean isMatch(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.getLottoNumber() == bonusNumber.getLottoNumber());
    }
}
