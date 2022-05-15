package lotto.domain;

import lotto.enums.Rank;

import java.util.HashMap;
import java.util.Map;

public class WinningStatistic {

    public static final int NO_WIN = 0;

    private final Map<Rank, Integer> statistic = new HashMap<>();

    public int count(Rank rank) {
        return statistic.getOrDefault(rank, NO_WIN);
    }

    public void collect(Rank rank) {
        statistic.put(rank, count(rank) + 1);
    }

    public double calculateRateOfReturn(Money purchaseAmount) {
        Money totalPrizeMoney = Money.zero();

        for (Rank rank : statistic.keySet()) {
            Money prizeMoney = rank.prizeMoney(statistic.get(rank));
            totalPrizeMoney = totalPrizeMoney.plus(prizeMoney);
        }
        return totalPrizeMoney.divideDecimal(purchaseAmount);
    }

}
