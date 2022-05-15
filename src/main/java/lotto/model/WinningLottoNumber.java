package lotto.model;

import java.util.HashSet;
import java.util.Objects;
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

    public LottoRank matchLottoRank(LottoNumber lottoNumber) {
        int matchLottoNumber = lottoNumber.countMatchLottoNumber(this.lottoNumber);
        boolean hasBonusNumber = lottoNumber.isContainNumber(this.bonusNumber);
        return LottoRank.findByHits(matchLottoNumber, hasBonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningLottoNumber that = (WinningLottoNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber) && Objects.equals(bonusNumber,
                that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber, bonusNumber);
    }
}
