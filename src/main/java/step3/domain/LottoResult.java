package step3.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.concurrent.atomic.AtomicLong;

public class LottoResult {
    private final EnumMap<Ranking, Integer> rankingMap;

    public LottoResult() {
        this.rankingMap = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values())
                .forEach(ranking -> rankingMap.put(ranking, 0));
    }

    public void updateHitRanking(Ranking ranking) {
        rankingMap.put(ranking, rankingMap.get(ranking) + 1);
    }

    public double calculateYield(int inputMoney) {
        return (double) winningAmount() / inputMoney;
    }

    public long winningAmount() {
        AtomicLong winningAmount = new AtomicLong(0L);
        rankingMap.forEach((ranking, hitCount) -> {
            winningAmount.addAndGet((long) (hitCount * ranking.getWinningMoney()));
        });
        return winningAmount.get();
    }

    public int rankingCount(Ranking ranking) {
        return rankingMap.get(ranking);
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "rankingMap=" + rankingMap +
                '}';
    }
}
