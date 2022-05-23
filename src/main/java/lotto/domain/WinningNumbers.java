package lotto.domain;

import lotto.exception.LottoException;
import lotto.exception.LottoExceptionType;

public class WinningNumbers {

    private final Lotto winner;
    private final LottoNumber bonusNumber;

    public WinningNumbers(final Lotto winner, final LottoNumber bonusNumber) {
        validate(winner, bonusNumber);
        this.winner = winner;
        this.bonusNumber =  bonusNumber;
    }

    private void validate(final Lotto winner, final LottoNumber bonusNumber) {
        if (winner.getLottoNumber().contains(bonusNumber)) {
            throw new LottoException(LottoExceptionType.DUPLICATE_BONUS_NUMBER);
        }
    }

    public Lotto getWinner() {
        return winner;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
