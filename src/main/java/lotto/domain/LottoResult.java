package lotto.domain;

import lotto.type.LottoRank;

import java.util.Map;

public class LottoResult {
    private final Map<Lotto, LottoRank> lottoResultMap;

    public LottoResult(Map<Lotto, LottoRank> lottoResultMap) {
        this.lottoResultMap = lottoResultMap;
    }

    public Map<Lotto, LottoRank> getLottoResultMap() {
        return lottoResultMap;
    }
}
