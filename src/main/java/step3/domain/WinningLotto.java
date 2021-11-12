package step3.domain;

import step3.common.exception.InvalidParamException;
import step3.domain.constance.LottoConstant;

public class WinningLotto {
    private final LottoNumbers winningLottoNumbers;
    private final LottoNumber bonusLottoNumber;

    private WinningLotto(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        this.winningLottoNumbers = winningNumbers;
        this.bonusLottoNumber = bonusNumber;
        valid();
    }

    public static WinningLotto of(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public int containCount(LottoNumbers lottoNumbers) {
        return winningLottoNumbers.containCount(lottoNumbers);
    }

    public boolean bonusMatch(LottoNumbers lottoNumbers) {
        return lottoNumbers.isBonusContain(bonusLottoNumber);
    }

    private void valid() {
        if (winningLottoNumbers.isBonusContain(bonusLottoNumber)) {
            throw new InvalidParamException(LottoConstant.BONUS_NUMBER_ALREADY_EXIST_MESSAGE);
        }
    }
}
