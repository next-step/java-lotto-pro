package lotto.domain;

import java.util.*;

public class Result {

    private final List<Rank> ranks;
    private final Money money;

    public Result(List<Rank> ranks, Money money) {
        this.ranks = ranks;
        this.money = money;
    }

    public double getProfitRate() {
        final int sum = ranks.stream()
                .mapToInt(Rank::getPrice)
                .sum();

        return money.profitRate(sum);
    }

    public Map<Rank, Integer> getResult() {
        final Map<Rank, Integer> map = new EnumMap(Rank.class);
        map.put(Rank.FIRST, 0);
        map.put(Rank.THIRD, 0);
        map.put(Rank.SECOND, 0);
        map.put(Rank.FORTH, 0);
        map.put(Rank.FIFTH, 0);

        ranks.stream()
                .filter(rank -> !rank.equals(Rank.NO_MATCH))
                .forEach(rank -> increase(map, rank));

        return map;
    }

    private void increase(Map<Rank, Integer> map, Rank rank) {
        final int count = map.get(rank);
        map.put(rank, count + 1);
    }
}
