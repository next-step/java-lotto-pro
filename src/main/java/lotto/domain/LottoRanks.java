package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRanks {
    private List<LottoRank> lottoRanks;

    public LottoRanks(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public List<LottoRank> getLottoRanks() {
        return new ArrayList<>(lottoRanks);
    }

    public int prize() {
        int prize = 0;
        for (LottoRank lottoRank : lottoRanks) {
            prize += lottoRank.getPrize();
        }
        return prize;
    }
}
