package lotto.domain;

public class WinningLotto extends Lotto {

    private final BonusLottoNumber bonusLottoNumber;

    public WinningLotto(int bonusNumber, int... numbers) {
        super(numbers);
        this.bonusLottoNumber = new BonusLottoNumber(bonusNumber, numbers);
    }
}
