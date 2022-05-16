package lotto;

import java.util.List;
import java.util.Set;

public class LottoNumbers {


    public List<LottoNumber> makeLottoNumbers(PickNumberStrategy pickNumberStrategy) {
        return pickNumberStrategy.pickLottoNumbers();
    }
}
