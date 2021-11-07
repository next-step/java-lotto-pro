package lotto.domain;

import lotto.exception.DuplicateWinningNumberException;

public class Winning {

    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    private Winning(final LottoNumbers lottoNumbers, final int bonusNumber) {
        this.winningNumbers = lottoNumbers;
        this.bonusNumber = new LottoNumber(bonusNumber);
        validationBonusNumber();
    }

    public static Winning of(final LottoNumbers lottoNumbers, final int bonusNumber) {
        return new Winning(lottoNumbers, bonusNumber);
    }

    private void validationBonusNumber() {
        if (winningNumbers.getLottoNumbers().contains(bonusNumber)) {
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
