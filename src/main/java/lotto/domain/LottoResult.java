package lotto.domain;

import java.util.*;

public class LottoResult {
    private final Map<LottoRank, Integer> winningRanks = new EnumMap<>(LottoRank.class);

    public LottoResult(List<Lotto> buyLottos, WinningNumber winningLotto) {
        for (Lotto lotto : new ArrayList<>(buyLottos)) {
            LottoRank lottoRank = LottoRank.of(winningLotto.matchCount(lotto), winningLotto.bonus(lotto));
            winningRanks.put(lottoRank, winningCount(lottoRank) + 1);
        }
    }

    public int winningCount(LottoRank lottoRank) {
        Integer winningCount = winningRanks.get(lottoRank);
        if (winningCount == null) {
            return 0;
        }
        return winningCount;
    }

    public double rateOfReturn(Money buyPrice) {
        return buyPrice.calculateRateOfReturn(winningMoney());
    }

    private Money winningMoney() {
        Money moneySum = new Money();
        for (LottoRank lottoRank : winningRanks.keySet()) {
            moneySum = sumRankMoney(moneySum, lottoRank);
        }
        return moneySum;
    }

    private Money sumRankMoney(Money moneySum, LottoRank lottoRank) {
        for (int i = 0; i < winningCount(lottoRank); i++) {
            moneySum = lottoRank.sumWinningMoney(moneySum);
        }
        return moneySum;
    }
}
