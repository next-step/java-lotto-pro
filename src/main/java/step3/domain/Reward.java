package step3.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Reward {

    private final Map<Integer, Integer> reward = new HashMap<>();
    private final Map<Integer, Long> criteria;

    private Reward() {
        throw new RuntimeException("Cannot use default constructor.");
    }

    private Reward(List<Integer> matchCounts, CriteriaProvider criteriaProvider) {
        this.criteria = criteriaProvider.get();
        init();
        input(matchCounts);
    }

    public static Reward generate(List<Integer> matchCounts, CriteriaProvider criteriaProvider) {
        return new Reward(matchCounts, criteriaProvider);
    }

    private void init() {
        criteria.keySet()
                .forEach(key -> reward.put(key, 0));
    }

    private void input(List<Integer> matchCounts) {
        matchCounts.forEach(this::input);
    }

    private void input(int matchCount) {
        if (criteria.containsKey(matchCount)) {
            reward.put(matchCount, reward.get(matchCount) + 1);
        }
    }

    public List<String> getStatistics() {
        return criteria.keySet()
                .stream()
                .map(this::generateStatistic)
                .collect(Collectors.toList());
    }

    private String generateStatistic(int matchCount) {
        return matchCount
                + "개 일치 ("
                + getTotalMoney(matchCount)
                + "원)- "
                + reward.get(matchCount)
                + "개";
    }

    public long getTotalMoney() {
        return criteria.keySet()
                .stream()
                .map(this::getTotalMoney)
                .mapToLong(money -> money)
                .sum();
    }

    private long getTotalMoney(int matchCount) {
        return criteria.get(matchCount) * reward.get(matchCount);
    }
}
