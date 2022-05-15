package step3.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        List<Ranking> rankings = Arrays.stream(Ranking.values())
                .filter(ranking -> ranking != Ranking.NONE)
                .collect(Collectors.toList());
        for (Ranking ranking : rankings) {
            text.append(String.format("%s- %d개\n", ranking.toString(), rankingCount(ranking)));
        }
        text.append(String.format("총 수익률은 %.02f입니다.", yield));
        return text.toString();
    }
}
