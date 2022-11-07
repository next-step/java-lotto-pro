package study.step4.models;

import study.step4.exception.BonusBallNumberInWinningLottoException;

public class BonusBall {
    private final LottoNumber bonusBallNumber;

    public BonusBall(LottoNumber bonusBallNumber) {
        this.bonusBallNumber = bonusBallNumber;
    }

    public BonusBall(String bonusBallNumber) {
        this(new LottoNumber(Integer.parseInt(bonusBallNumber)));
    }

    public void validateNotInWinningLotto(WinningLotto winningLotto) {
        if (winningLotto.contains(bonusBallNumber)) {
            throw new BonusBallNumberInWinningLottoException("보너스 번호는 당첨 번호와 달라야 합니다.");
        }
    }

    public boolean isEqualValue(LottoNumber lottoNumber) {
        return bonusBallNumber.compare(lottoNumber) == 0;
    }
}
