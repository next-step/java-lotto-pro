package lotto.domain;

import lotto.enums.LottoRank;

import java.util.List;

public class LottoRanks {
    private final List<LottoRank> lottoRanks;

    public LottoRanks(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public List<LottoRank> getLottoRanks() {
        return lottoRanks;
    }
}
