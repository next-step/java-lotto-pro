package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Rank> lottoRanks;

    public Lotto(List<Rank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public int getMatchRankCount(Rank rank) {
        return Collections.frequency(lottoRanks, rank);
    }
}
