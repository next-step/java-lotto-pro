package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Statistics {

    private static final int PERCENTAGE = 100;
    private static final int DEFAULT_COUNT = 0;
    private Map<Integer, Integer> statistics;

    public Statistics(Lottos lottos, Lotto winLotto) {
        statistics = setStatistics(lottos, winLotto);
    }

    private Map<Integer, Integer> setStatistics(Lottos lottos, Lotto winLotto) {
        Map<Integer, Integer> statistics = new HashMap<>();
        for (int i = 0; i < lottos.getLottosSize(); i++) {
            Integer matchCnt = lottos.getMatchNumCnt(i, winLotto);
            Integer lottoCnt = statistics.getOrDefault(matchCnt, DEFAULT_COUNT);
            statistics.put(matchCnt, lottoCnt + 1);
        }

        return statistics;
    }

    public double getYield(Payment payment) {
        double rewards = getRewardsByMatches();
        return Math.floor(rewards / payment.getPayment() * PERCENTAGE) / PERCENTAGE;
    }

    private double getRewardsByMatches() {
        double rewards = 0;

        for (Integer match : statistics.keySet()) {
            rewards += (Winning.getRewardsByMatch(match) * statistics.get(match));
        }

        return rewards;
    }

    public int getMatchedLottoCnt(Integer matches) {
        return statistics.getOrDefault(matches, DEFAULT_COUNT);
    }
}
