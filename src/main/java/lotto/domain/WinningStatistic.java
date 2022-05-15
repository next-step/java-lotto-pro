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

    public double calculateRateOfReturn(double purchaseAmount) {
        int totalPrizeMoney = 0;

        for (Rank rank : statistic.keySet()) {
            totalPrizeMoney += rank.prizeMoney(statistic.get(rank));
        }
        return makeTwoDecimalPlace(totalPrizeMoney / purchaseAmount);
    }

    private double makeTwoDecimalPlace(double late) {
        return Math.floor(late * 100) / 100.0;
    }

    public Map<Rank, Integer> getStatistic() {
        return statistic;
    }
}
