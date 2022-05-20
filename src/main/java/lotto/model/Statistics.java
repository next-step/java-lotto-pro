package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private Map<Rank, Integer> resultMap = new HashMap() {{
        put(Rank.valueOf(6, false), 0);
        put(Rank.valueOf(5, true), 0);
        put(Rank.valueOf(5, false), 0);
        put(Rank.valueOf(4, false), 0);
        put(Rank.valueOf(3, false), 0);
        put(Rank.valueOf(0, false), 0);
    }};

    public Statistics() {}

    public Map<Rank, Integer> culculate(WinLotto winLotto, List<Lotto> autoLottos, List<Lotto> manualLottos) {
        manualLottos.forEach(lotto -> compareNumber(winLotto, lotto));
        autoLottos.forEach(lotto -> compareNumber(winLotto, lotto));
        return resultMap;
    }

    private void compareNumber(WinLotto winLotto, Lotto lotto) {
        resultMap.computeIfPresent(
                Rank.valueOf(lotto.getMatchCount(winLotto), lotto.isMatchedBonus(winLotto)), (k, v) ->
                        Math.toIntExact(v + 1));
    }

    public long getTotalPrize() {
        return resultMap.entrySet().stream()
                .mapToLong(rank -> rank.getKey().getWinningMoney() * rank.getValue())
                .sum();
    }

    public double getTotalCount() {
        return resultMap.entrySet().stream()
                .mapToLong(rank -> rank.getValue())
                .sum();
    }

    public double getProfit() {
        return Math.floor((getTotalPrize() / (getTotalCount() * 1000)) * 100) / 100;
    }
}
