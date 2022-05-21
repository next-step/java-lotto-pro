package lotto.domain;

import java.util.List;

public class LottoRanks {
    private List<LottoRank> lottoRanks;

    public LottoRanks(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public List<LottoRank> getLottoRanks() {
        return lottoRanks;
    }

    public int prize() {
        int prize = 0;
        for (LottoRank lottoRank : lottoRanks) {
            prize += lottoRank.getPrize();
        }
        return prize;
    }

    public int size() {
        return lottoRanks.size();
    }
}
