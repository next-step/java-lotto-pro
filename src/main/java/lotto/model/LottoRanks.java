package lotto.model;

import java.util.List;

public class LottoRanks {
    private List<LottoRank> lottoRanks;

    private LottoRanks(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public static LottoRanks of(List<LottoRank> lottoRanks) {
        return new LottoRanks(lottoRanks);
    }

    public List<LottoRank> getLottoRanks() {
        return lottoRanks;
    }
}
