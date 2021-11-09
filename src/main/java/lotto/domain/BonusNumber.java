package lotto.domain;

public class BonusNumber {
    private LottoNumber bonusNumber;
    public BonusNumber(String bonusNumber) {
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public String getBonusNumber() {
        return this.bonusNumber.getValue();
    }
}
