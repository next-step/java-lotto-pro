package lotto.domain;

import lotto.domain.factory.LottoFactory;

public class WinningNumber {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningNumber(String winningLotto, String bonusNumber) {
        this(LottoFactory.create(winningLotto), LottoNumber.of(bonusNumber));
    }

    public WinningNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int matchCount(Lotto lotto) {
        return lotto.matchCount(winningLotto);
    }

    public boolean bonus(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
