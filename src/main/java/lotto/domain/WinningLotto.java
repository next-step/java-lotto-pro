package lotto.domain;

import static lotto.domain.Lotto.DUPLICATE_EXCEPTION_MESSAGE;

public class WinningLotto {

    private final Lotto winningLotto;
    private final Number bonusBall;

    public WinningLotto(Lotto lotto, Number bonusBall) {
        this.winningLotto = lotto;
        validateDuplicateBonusBall(bonusBall);
        this.bonusBall = bonusBall;
    }

    private void validateDuplicateBonusBall(Number bonusBall) {
        if (winningLotto.contains(bonusBall)) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public Number getBonusBall() {
        return this.bonusBall;
    }

    public boolean contains(Number number) {
        return this.winningLotto.contains(number);
    }
}
