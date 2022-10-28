package step3.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Reward {

    private final Map<Integer, Integer> result = new HashMap<>();
    private final Map<Integer, Long> criteria;

    private Reward() {
        throw new RuntimeException("Cannot use default constructor.");
    }

    private Reward(List<Lotto> lottos, Numbers winningNumbers, CriteriaProvider criteriaProvider) {
        this.criteria = criteriaProvider.get();
        initResult();
        generateResult(lottos, winningNumbers);
    }

    public static Reward generate(List<Lotto> lottos, Numbers winningNumbers,
                                  CriteriaProvider criteriaProvider) {
        return new Reward(lottos, winningNumbers, criteriaProvider);
    }

    private void initResult() {
        criteria.keySet()
                .forEach(key -> result.put(key, 0));
    }

    private void generateResult(List<Lotto> lottos, Numbers winningNumbers) {
        lottos.forEach(lotto -> {
            int matchCount = lotto.getMatchCount(winningNumbers);
            if (criteria.containsKey(matchCount)) {
                result.put(matchCount, result.get(matchCount) + 1);
            }
        });
    }

    public List<String> generateStatistics() {
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
                + result.get(matchCount)
                + "개";
    }

    private String getTotalMoney(int matchCount) {
        return String.valueOf(criteria.get(matchCount) * result.get(matchCount));
    }
}
