package lotto.domain;

import lotto.exception.DuplicateWinningNumberException;

public class Winning {

    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    private Winning(final LottoNumbers lottoNumbers, final LottoNumber bonusNumber) {
        this.winningNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
        validationBonusNumber();
    }

    public static Winning of(final LottoNumbers lottoNumbers, final int bonusNumber) {
        return new Winning(lottoNumbers, new LottoNumber(bonusNumber));
    }

    private void validationBonusNumber() {
        if (winningNumbers.hasNumber(bonusNumber)) {
            throw new DuplicateWinningNumberException();
        }
    }

    public LottoNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
