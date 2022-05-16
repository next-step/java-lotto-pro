package lotto.domain;

import lotto.common.ErrorMessage;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(String numbers, int bonus) {
        this.winningLotto = new Lotto(LottoNumbers.from(numbers));
        LottoNumber bonusNumber = LottoNumber.from(bonus);
        validateDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(LottoNumber bonusNumber) {
        if (this.winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE_ERROR.getErrorMessage());
        }
    }

    public Rank match(Lotto lotto) {
        return Rank.valueOf(winningLotto.matchCounts(lotto), lotto.contains(bonusNumber));
    }
}
