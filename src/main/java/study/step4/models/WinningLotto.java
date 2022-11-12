package study.step4.models;

import study.step4.exception.BonusBallNumberInWinningLottoException;

public class WinningLotto {
    private final Lotto winningLottoNumbers;

    public WinningLotto(String winningLottoNumbers) {
        this.winningLottoNumbers = new Lotto(winningLottoNumbers);
    }

    public boolean contains(LottoNumber bonusBallNumber) {
        return winningLottoNumbers.contains(bonusBallNumber);
    }

    public void validateNotInWinningLotto(LottoNumber bonusBall) {
        if (winningLottoNumbers.contains(bonusBall)) {
            throw new BonusBallNumberInWinningLottoException("보너스 번호는 당첨 번호와 달라야 합니다.");
        }
    }
}
