package step3.model;

import step3.constant.Rank;

import java.util.*;

public class LottoResult {

    private List<Rank> ranks = new ArrayList<>();

    public void addResult(int sameNumberCount, boolean containBonus) {
        ranks.add(Rank.search(sameNumberCount, containBonus));
    }

    public String createSameCountMessage(Rank rank) {
        return rank.sameCountMessage() +
                "(" +
                rank.winningMoney() +
                "원" +
                ")- " +
                totalSameCount(rank) +
                "개";
    }

    private long totalSameCount(Rank compareRank) {
        return ranks.stream()
                .filter(rank -> rank == compareRank)
                .count();
    }

    public String createLottoStatisticsMessage(int lottoSize) {
        int totalWinningPrice = sumWinningPrice();
        return new StringBuilder("총 수익률은 ")
                .append(calculatorResult(totalWinningPrice, lottoSize))
                .append("입니다.")
                .toString();
    }

    public int sumWinningPrice() {
        return ranks.stream().mapToInt(Rank::winningMoney).sum();
    }

    private String calculatorResult(int totalWinningPrice, int lottoSize) {
        double calculatorResult = Double.valueOf(totalWinningPrice) / Double.valueOf(lottoSize * 1000);
        return String.format("%.2f", calculatorResult);
    }

}
