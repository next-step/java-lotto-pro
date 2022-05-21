package lotto.domain;

import lotto.enums.LottoRank;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<LottoRank, Integer> winningCount = new HashMap<>();

    public LottoResult(Lottos lottos, Lotto winningLotto, LottoNumber bonusNumber) {
        updateWinningCount(lottos, winningLotto, bonusNumber);
    }

    public static LottoResult of(Lottos lottos, Lotto winningLotto, LottoNumber bonusNumber) {
        return new LottoResult(lottos, winningLotto, bonusNumber);
    }

    private void updateWinningCount(Lottos lottos, Lotto winningLotto, LottoNumber bonusNumber) {
        for (Lotto lotto : lottos.getLottosAsUnmodifiableList()) {
            LottoRank rank = LottoRank.valueOf(lotto.countMatchedNumbers(winningLotto), lotto.hasNumber(bonusNumber));
            winningCount.put(rank, winningCount.getOrDefault(rank, 0) + 1);
        }
    }

    public int winningPrize() {
        int winningPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            winningPrize += winningCount.getOrDefault(rank, 0) * rank.getPrize();
        }
        return winningPrize;
    }

    public int winningCountByRank(LottoRank rank) {
        return winningCount.getOrDefault(rank, 0);
    }
}
