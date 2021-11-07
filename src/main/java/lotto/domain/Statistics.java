package lotto.domain;

import java.util.EnumMap;
import java.util.Set;

public class Statistics {
    private final EnumMap<Ranking, Integer> rankingMap = new EnumMap<Ranking, Integer>(Ranking.class);

    public void record(Ranking ranking) {
        rankingMap.computeIfPresent(ranking, (key,value) -> value +1);
        rankingMap.putIfAbsent(ranking,1);
    }

    public Integer getCount(Ranking ranking) {
        if (rankingMap.get(ranking) == null) {
            return 0;
        }
        return rankingMap.get(ranking);
    }

    public double calculateEarningRate(Money money) {
        Set<Ranking> rankings = rankingMap.keySet();
        Money totalPrize = rankings.stream()
                .map(ranking -> new Money(ranking.getPrize()).multiply(rankingMap.get(ranking)))
                .reduce(new Money(0), (Money::plus));
        return totalPrize.calculateRate(money);

    }

}