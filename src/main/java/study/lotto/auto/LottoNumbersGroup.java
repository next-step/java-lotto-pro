package study.lotto.auto;

import java.util.List;

public class LottoNumbersGroup {

    private final List<LottoNumbers> lottoNumbersList;

    public LottoNumbersGroup(List<LottoNumbers> lottoNumbersList) {
        this.lottoNumbersList = lottoNumbersList;
    }

    public List<LottoNumbers> getLottoNumbersList() {
        return lottoNumbersList;
    }
}
