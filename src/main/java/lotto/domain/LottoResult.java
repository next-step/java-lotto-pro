package lotto.domain;

import java.util.*;

public class LottoResult {
    private final Map<LottoRank, Integer> winningRanks = new EnumMap<>(LottoRank.class);

    public LottoResult(List<Lotto> lottos, Lotto winningLotto) {
        for (Lotto lotto : new ArrayList<>(lottos)) {
            LottoRank lottoRank = LottoRank.of(lotto.matchCount(winningLotto));
            winningRanks.put(lottoRank, getWinningCount(lottoRank) + 1);
        }
    }

    public int getWinningCount(LottoRank lottoRank) {
        Integer winningCount = winningRanks.get(lottoRank);
        if (winningCount == null) {
            return 0;
        }
        return winningCount;
    }
}
