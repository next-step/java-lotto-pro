package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.strategy.PickNumberStrategy;

public class LottoNumbers {

    private List<LottoNumber> values;

    public LottoNumbers(PickNumberStrategy pickNumberStrategy) {
        values = pickNumberStrategy.pickLottoNumbers();
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.values = lottoNumbers;
    }

    public List<LottoNumber> getValues() {
        return Collections.unmodifiableList(values);
    }

}
