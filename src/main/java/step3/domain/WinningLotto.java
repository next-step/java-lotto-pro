package step3.domain;

import java.util.List;

import step3.common.exception.InvalidParamException;
import step3.domain.constance.LottoConstant;

public class WinningLotto {
    private final LottoNumbers winningLottoNumbers;
    private final LottoNumber bonusLottoNumber;

    private WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.winningLottoNumbers = LottoNumbers.of(numbers);
        this.bonusLottoNumber = LottoNumber.of(bonusNumber);
        valid();
    }

    public static WinningLotto of(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
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
