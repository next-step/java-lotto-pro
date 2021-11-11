package nextstep.lotto.domain;

import java.util.List;
import java.util.Objects;

public class BonusBall {

    private final LottoNumber lottoNumber;

    public BonusBall(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public Boolean isContain(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusBall bonusBall = (BonusBall) o;
        return Objects.equals(lottoNumber, bonusBall.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
