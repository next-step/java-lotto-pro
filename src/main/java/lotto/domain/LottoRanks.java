package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRanks {
    private List<LottoRank> lottoRanks;

    public LottoRanks(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public int prize() {
        int prize = 0;
        for (LottoRank lottoRank : lottoRanks) {
            prize += lottoRank.getPrize();
        }
        return prize;
    }

    public int matchRank(LottoRank lottoRank) {
        return (int) lottoRanks.stream().filter(rank -> rank.isMatchRank(lottoRank.getMatch(), lottoRank.hasBonus())).count();
    }

    public List<LottoRank> getLottoRanks() {
        return new ArrayList<>(lottoRanks);
    }
}
