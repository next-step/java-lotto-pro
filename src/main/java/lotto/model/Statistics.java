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

    public Map<Rank, Integer> getResultMap() {
        return resultMap;
    }

    public Statistics(Lotto win, List<Lotto> lottos) {
        lottos.forEach(lotto -> compareNumber(win, lotto, null));
    }

    public Statistics(Lotto win, LottoNumber bonus, List<Lotto> lottos) {
        lottos.forEach(lotto -> compareNumber(win, lotto, bonus));
    }

    private void compareNumber(Lotto win, Lotto lotto, LottoNumber bonus) {
        long count = lotto.getLottoNumber().stream()
                .filter(lottoNumber -> win.getLottoNumber().contains(lottoNumber))
                .count();

        boolean matchBonus = lotto.getLottoNumber().contains(bonus);

        resultMap.computeIfPresent(Rank.valueOf(count, matchBonus), (k, v) -> Math.toIntExact(v + 1));
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
