package step3.domain;

public class WinningLotto {

    private final LottoNumbers winningNumber;

    int bonusNumber;

    public WinningLotto(LottoNumbers winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public LottoNumbers getWinningNumber() {
        return winningNumber;
    }

}
