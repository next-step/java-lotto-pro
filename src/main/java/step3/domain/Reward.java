package step3.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Reward {

    private final Map<Rank, Integer> reward = new LinkedHashMap<>();

    private Reward() {
        throw new RuntimeException("Cannot use default constructor.");
    }

    private Reward(List<Rank> ranks) {
        init();
        input(ranks);
    }

    public static Reward generate(List<Rank> ranks) {
        return new Reward(ranks);
    }

    private void init() {
        Arrays.stream(Rank.values())
                .sorted(Comparator.comparing(Rank::getCountOfMatch))
                .filter(rank -> !rank.equals(Rank.MISS))
                .forEach(rank -> reward.put(rank, 0));
    }

    private void input(List<Rank> ranks) {
        ranks.forEach(this::input);
    }

    private void input(Rank rank) {
        if (reward.containsKey(rank)) {
            reward.put(rank, reward.get(rank) + 1);
        }
    }

    public List<String> getStatistics() {
        return reward.keySet()
                .stream()
                .map(this::generateStatistic)
                .collect(Collectors.toList());
    }

    private String generateStatistic(Rank rank) {
        return rank.getCountOfMatch()
                + "개 일치 ("
                + rank.getWinningMoney()
                + "원)- "
                + reward.get(rank)
                + "개";
    }

    public String getWinningMoneyRate(Money payment) {
        return payment.rate(getWinningMoney());
    }

    private long getWinningMoney() {
        return reward.keySet()
                .stream()
                .map(this::getWinningMoney)
                .mapToLong(money -> money)
                .sum();
    }

    private long getWinningMoney(Rank rank) {
        return (long) rank.getWinningMoney() * reward.get(rank);
    }
}