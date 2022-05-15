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

    public Statistics(Lotto win, LottoNumber bonus, List<Lotto> lottos) {
        validateBonus(win, bonus);
        lottos.forEach(lotto -> compareNumber(win, lotto, bonus));
    }

    private void validateBonus(Lotto win, LottoNumber bonus) {
        if(win.getLottoNumber().contains(bonus)) {
            throw new IllegalArgumentException("보너스번호가 지난당첨번호안에 중복이 될수 없습니다.");
        }
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
