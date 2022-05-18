package lotto.domain;

import java.util.*;

public class LottoResult {
    private final Map<LottoRank, Integer> lottoResult = new EnumMap<>(LottoRank.class);

    public LottoResult(List<Lotto> lottos, Lotto winningLotto) {
        for (Lotto lotto : lottos) {
            LottoRank lottoRank = LottoRank.of(lotto.matchCount(winningLotto));
            lottoResult.put(lottoRank, getWinningCount(lottoRank) + 1);
        }
    }

    public int getWinningCount(LottoRank lottoRank) {
        return Optional.ofNullable(lottoResult.get(lottoRank))
                .orElse(0);
    }
}
