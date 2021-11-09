package lotto.domain;

public class BonusNumber {
    private LottoNumber bonusNumber;
    public BonusNumber(String bonusNumber) {
        this.bonusNumber = new LottoNumber(Integer.parseInt(bonusNumber));
    }

    public LottoNumber getBonusNumber() {
        return this.bonusNumber;
    }
}
