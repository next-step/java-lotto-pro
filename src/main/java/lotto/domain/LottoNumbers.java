package lotto.domain;

import java.util.List;
import lotto.strategy.PickNumberStrategy;

public class LottoNumbers {


    public List<LottoNumber> makeLottoNumbers(PickNumberStrategy pickNumberStrategy) {
        return pickNumberStrategy.pickLottoNumbers();
    }
}
