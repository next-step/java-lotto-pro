package step3.domain;

import step3.common.exception.InvalidParamException;
import step3.domain.constance.LottoConstant;

public class WinningLotto {
    private final LottoNumbers winningLottoNumbers;
    private final LottoNumber bonusLottoNumber;

    private WinningLotto(LottoNumbers winningLottoNumbers, LottoNumber bonusLottoNumber) {
        valid(winningLottoNumbers, bonusLottoNumber);
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public static WinningLotto of(int[] numbers, int bonusNumber) {
        return new WinningLotto(new LottoNumbers(numbers), LottoNumber.of(bonusNumber));
    }

    public int containCount(LottoNumbers lottoNumbers) {
        return winningLottoNumbers.containCount(lottoNumbers);
    }

    public boolean bonusMatch(LottoNumbers lottoNumbers) {
        return lottoNumbers.isBonusContain(bonusLottoNumber);
    }

    public Object match(LottoNumbers lottoNumber) {
        return null;
    }

    private void valid(LottoNumbers winningLottoNumbers, LottoNumber bonusLottoNumber) {
        if (winningLottoNumbers.isBonusContain(bonusLottoNumber)) {
            throw new InvalidParamException(LottoConstant.BONUS_NUMBER_ALREADY_EXIST_MESSAGE);
        }
    }
}
