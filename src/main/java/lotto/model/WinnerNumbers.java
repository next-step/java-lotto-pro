package lotto.model;

public class WinnerNumbers {

    private LottoNumbers firstPrizeNumbers;
    private BonusNumber bonusNumber;

    public WinnerNumbers(final LottoNumbers firstPrizeNumbers, final BonusNumber bonusNumber) {
        this.firstPrizeNumbers = firstPrizeNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoNumbers getFirstPrizeNumbers() {
        return firstPrizeNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

}
