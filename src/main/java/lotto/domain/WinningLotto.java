package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {

    private final BonusLottoNumber bonusLottoNumber;

    public WinningLotto(int bonusNumber, int... numbers) {
        super(numbers);
        this.bonusLottoNumber = new BonusLottoNumber(bonusNumber, numbers);
    }

    public boolean checkMatchBonus(Lotto lotto) {
        return hasBonusNumber(lotto);
    }

    private boolean hasBonusNumber(Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        return lottoNumbers.stream().anyMatch(lottoNumber -> lottoNumber.isBonusNumber(bonusLottoNumber));
    }
}
