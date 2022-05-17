package lotto.domain;

import java.util.Objects;
import lotto.strategy.PickNumberStrategy;

public class Lotto {

    private LottoNumbers lottoNumbers;

    public Lotto(PickNumberStrategy pickNumberStrategy) {
        this.lottoNumbers = new LottoNumbers(pickNumberStrategy);
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers getNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
