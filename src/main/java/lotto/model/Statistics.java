package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private Map<Rank, Integer> resultMap = new HashMap() {{
        put(Rank.getRank(6), 0);
        put(Rank.getRank(5), 0);
        put(Rank.getRank(4), 0);
        put(Rank.getRank(3), 0);
        put(Rank.getRank(0), 0);
    }};

    public Map<Rank, Integer> getResultMap() {
        return resultMap;
    }

    public Statistics(Lotto win, List<Lotto> lottos) {
        lottos.forEach(lotto -> compareNumber(win, lotto));
    }

    private void compareNumber(Lotto win, Lotto lotto) {
        long count = lotto.getLottoNumber().stream()
                .filter(lottoNumber -> win.getLottoNumber().contains(lottoNumber))
                .count();

        resultMap.computeIfPresent(Rank.getRank(count), (k, v) -> Math.toIntExact(v + 1));
    }

    public long getTotalPrize() {
        return resultMap.entrySet().stream()
                .mapToLong(rank -> rank.getKey().getPrize() * rank.getValue())
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
