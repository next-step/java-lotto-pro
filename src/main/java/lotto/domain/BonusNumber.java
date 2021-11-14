package lotto.domain;

import java.util.Objects;

public class BonusNumber {
    private final LottoNumber lottoNumber;

    public BonusNumber(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BonusNumber)) {
            return false;
        }
        BonusNumber that = (BonusNumber)o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    public boolean isBonus(LottoNumber lottoNumber) {
        return this.lottoNumber.equals(lottoNumber);
    }
}
