package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Statistics {

    private static final int PERCENTAGE = 100;
    private static final int DEFAULT_COUNT = 0;
    private Map<Winning, Integer> statistics;

    public Statistics(Lottos lottos, Lotto winLotto, LottoNumber bonusBall) {
        statistics = setStatistics(lottos, winLotto, bonusBall);
    }

    private Map<Winning, Integer> setStatistics(Lottos lottos, Lotto winLotto, LottoNumber bonusBall) {
        Map<Winning, Integer> statistics = new HashMap<>();

        for (Lotto lotto : lottos.getLottoList()) {
            int matches = lotto.countMatchNum(winLotto);
            boolean matchBonus = lotto.isContained(bonusBall);
            Winning winning = Winning.valueOf(matches, matchBonus);
            int lottoCnt = statistics.getOrDefault(winning, DEFAULT_COUNT);
            statistics.put(winning, lottoCnt + 1);
        }

        return statistics;
    }

    public double getYield(Payment payment) {
        double rewards = getRewardsByWinning();
        return Math.floor(rewards / payment.getPayment() * PERCENTAGE) / PERCENTAGE;
    }

    public double getRewardsByWinning() {
        return statistics.keySet().stream()
                .mapToDouble(winning -> winning.getReward() * statistics.get(winning))
                .sum();
    }

    public int getLottoCntByWinning(Winning winning) {
        return statistics.getOrDefault(winning, DEFAULT_COUNT);
    }
}
