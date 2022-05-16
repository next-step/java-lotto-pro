package lotto;

import lotto.domain.LottoNumbers;
import lotto.strategy.PickNumberStrategy;

public class Lotto {

    private LottoNumbers lottoNumbers;

    public Lotto(PickNumberStrategy pickNumberStrategy) {
        this.lottoNumbers = new LottoNumbers(pickNumberStrategy);
    }

    public LottoNumbers getNumbers() {
        return lottoNumbers;
    }
}
