package lotto.domain.lotto;

import lotto.constant.LottoConstant;
import lotto.status.ErrorStatus;

import java.util.List;

public class WinnerLotto {

    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinnerLotto(List<LottoNumber> lottoNumbers, LottoNumber bonus) {
        validateLottoNumber(lottoNumbers);
        validateBonusNumber(lottoNumbers, bonus);
        this.bonusNumber = bonus;
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumber(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LottoConstant.LOTTO_COMPONENT_COUNT) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_LOTTO_COMPONENT.getMessage());
        }
    }

    private void validateBonusNumber(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorStatus.INVALID_BONUS_NUMBER.getMessage());
        }
    }

    public boolean matchBonusNumber(LottoNumber lottoNumber) {
        return bonusNumber.equals(lottoNumber);
    }

    public boolean containLottoNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
