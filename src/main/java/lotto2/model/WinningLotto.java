package lotto2.model;

public class WinningLotto {
    private final Lotto lotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
