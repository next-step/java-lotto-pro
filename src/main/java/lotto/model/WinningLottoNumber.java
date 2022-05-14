package lotto.model;

import java.util.HashSet;
import java.util.Set;

public class WinningLottoNumber {
    private final LottoNumber lottoNumber;
    private final Number bonusNumber;

    public WinningLottoNumber(LottoNumber lottoNumber, Number bonusNumber) {
        validateDuplicateBonusNumber(lottoNumber, bonusNumber);
        this.lottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateBonusNumber(LottoNumber lottoNumber, Number bonusNumber) {
        Set<Number> lottoNumberSet = new HashSet<>(lottoNumber.getLottoNumber());
        if (lottoNumberSet.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호가 중복됩니다.");
        }
    }

    public int countMatchLottoNumber(LottoNumber lottoNumber) {
        return lottoNumber.countMatchLottoNumber(this.lottoNumber);
    }

    public boolean hasBonusNumber(LottoNumber lottoNumber) {
        return lottoNumber.isContainNumber(this.bonusNumber);
    }
}
