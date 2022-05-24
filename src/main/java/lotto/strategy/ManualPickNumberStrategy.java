package lotto.strategy;

import java.util.Collections;
import java.util.List;
import lotto.domain.LottoNumber;

public class ManualPickNumberStrategy implements PickNumberStrategy {

    private final List<LottoNumber> lottoNumbers;

    public ManualPickNumberStrategy(List<LottoNumber> lottoNumbers) {
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public List<LottoNumber> pickLottoNumbers() {
        return lottoNumbers;
    }
}
