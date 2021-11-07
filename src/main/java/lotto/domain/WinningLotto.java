package lotto.domain;

import lotto.exception.InputDataErrorCode;
import lotto.exception.InputDataException;

public class WinningLotto {
    private final Lotto lotto;
    private final Ball bonusBall;

    public WinningLotto(Lotto lotto, Ball bonusBall) {
        checkExistBonusNumberInWinningLotto(lotto, bonusBall);
        this.lotto = lotto;
        this.bonusBall = bonusBall;
    }

    public int match(Lotto inputLotto) {
        return lotto.match(inputLotto);
    }

    public boolean isMatchBonusBall(Lotto lotto) {
        return lotto.contains(this.bonusBall);
    }

    public Lotto lotto(){
        return this.lotto;
    }

    public Ball bonusBall(){
        return this.bonusBall;
    }

    private void checkExistBonusNumberInWinningLotto(Lotto lotto, Ball bonusBall) {
        if (lotto.contains(bonusBall)) {
            throw new InputDataException(InputDataErrorCode.DUPLICATE_BONUS_NUMBER_IN_WINNING_LOTTO_NUMBER);
        }
    }


}
