package lotto.domain;

import lotto.exception.LottoException;

import java.util.List;

public class WinningLotto extends Lotto {

    protected static final String BONUS_NUMBER_ERROR = "보너스 볼은 당첨 번호와 같을 수 없습니다.";

    private final LottoNumber bonusLottoNumber;

    public WinningLotto(int bonusNumber, int... numbers) {
        super(numbers);
        validateBonusNumber(bonusNumber);
        this.bonusLottoNumber = new LottoNumber(bonusNumber);
    }

    public boolean checkMatchBonus(Lotto lotto) {
        return hasBonusNumber(lotto);
    }

    private boolean hasBonusNumber(Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        return lottoNumbers.stream().anyMatch(lottoNumber -> lottoNumber.isBonusNumber(bonusLottoNumber));
    }

    private void validateBonusNumber(int bonusNumber) {
        LottoNumber lottoNumber = new LottoNumber(bonusNumber);
        if (getLottoNumbers().contains(lottoNumber)) {
            throw new LottoException(BONUS_NUMBER_ERROR);
        }
    }
}
