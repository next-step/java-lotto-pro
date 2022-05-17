package step3.domain;

import java.util.Arrays;
import java.util.EnumMap;

public class LottoResult {
    private final EnumMap<Ranking, Integer> rankingMap;
    private double winningAmount;

    public LottoResult() {
        this.rankingMap = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values())
                .forEach(ranking -> rankingMap.put(ranking, 0));
        this.winningAmount = 0L;
    }

    public void update(Ranking ranking) {
        rankingMap.put(ranking, rankingMap.get(ranking) + 1);
        winningAmount += ranking.getWinningMoney();
    }

    public double calculateYield(int inputMoney) {
        return winningAmount / (double) inputMoney;
    }

    public int rankingCount(Ranking ranking) {
        return rankingMap.get(ranking);
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "rankingMap=" + rankingMap +
                ", winningAmount=" + winningAmount +
                '}';
    }
}
