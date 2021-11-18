package lotto.view;

import lotto.model.LottoResult;
import lotto.model.Rank;

public class ResultView {
    public void printResult(LottoResult result, double roi) {
        showWinningStatistics(result);
        showReturnOnInvestment(roi);
    }

    private void showWinningStatistics(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(getWinningMessage(lottoResult, Rank.FIFTH_PRIZE));
        System.out.println(getWinningMessage(lottoResult, Rank.FOURTH_PRIZE));
        System.out.println(getWinningMessage(lottoResult, Rank.THIRD_PRIZE));
        System.out.println(getWinningMessage(lottoResult, Rank.SECOND_PRIZE));
        System.out.println(getWinningMessage(lottoResult, Rank.FIRST_PRIZE));
    }

    private String getWinningMessage(LottoResult lottoResult, Rank rank) {
        final long winningCount = lottoResult.getCountOf(rank);
        final String bonusBallMessage = rank.needBonus() ? ", 보너스 볼 일치" : "";
        return String.format("%d개 일치%s (%s원)- %d개",
                rank.getMatchCount(),
                bonusBallMessage,
                rank.getReward(),
                winningCount);
    }

    private void showReturnOnInvestment(double roi) {
        System.out.printf("총 수익률은 %.2f입니다.%n", roi);
    }
}
