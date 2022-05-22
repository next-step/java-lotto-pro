package lotto.domain;

import static lotto.constants.Message.INPUT_BONUS_ERROR;

public class WinningLotto {
    private final Lotto winningNumbers;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validBonusNumberUnique(lotto, bonusNumber);
        this.winningNumbers = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validBonusNumberUnique(Lotto lotto, LottoNumber bonusNumber) {
        int count = (int) lotto.getLottoNumbers().stream()
                .filter(lottoNumber -> lottoNumber.equals(bonusNumber))
                .count();

        if (count > 0) {
            throw new IllegalArgumentException(INPUT_BONUS_ERROR);
        }
    }
}
