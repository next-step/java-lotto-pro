package lotto.domain;

import java.util.List;

public class LottoResult {
    private List<LottoRank> lottoResult;

    public LottoResult(List<LottoRank> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public List<LottoRank> getLottoResult() {
        return lottoResult;
    }
}
