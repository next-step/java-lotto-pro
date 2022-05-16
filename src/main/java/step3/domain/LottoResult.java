package step3.domain;

import java.util.Arrays;
import java.util.EnumMap;

public class LottoResult {
    private final EnumMap<Ranking, Integer> rankingMap;
    private double winningAmount;
    private double yield;

    public LottoResult() {
        this.rankingMap = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values())
                .forEach(ranking -> rankingMap.put(ranking, 0));
        this.winningAmount = 0L;
        this.yield = 0L;
    }

    public void update(Ranking ranking) {
        rankingMap.put(ranking, rankingMap.get(ranking) + 1);
        winningAmount += ranking.getWinningMoney();
    }

    public void calculateYield(int inputMoney) {
        this.yield = winningAmount / (double) inputMoney;
    }

    public int rankingCount(Ranking ranking) {
        return rankingMap.get(ranking);
    }

    public double getYield() {
        return yield;
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "rankingMap=" + rankingMap +
                ", winningAmount=" + winningAmount +
                '}';
    }
}
