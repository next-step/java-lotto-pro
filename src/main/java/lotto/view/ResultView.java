package lotto.view;

import lotto.model.LottoResult;
import lotto.model.Winning;

public class ResultView {
    public void printResult(LottoResult result, double roi) {
        showWinningStatistics(result);
        showReturnOnInvestment(roi);
    }

    private void showWinningStatistics(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(getWinningMessage(lottoResult, Winning.FIFTH_PRIZE));
        System.out.println(getWinningMessage(lottoResult, Winning.FOURTH_PRIZE));
        System.out.println(getWinningMessage(lottoResult, Winning.THIRD_PRIZE));
        System.out.println(getWinningMessage(lottoResult, Winning.SECOND_PRIZE));
        System.out.println(getWinningMessage(lottoResult, Winning.FIRST_PRIZE));
    }

    private String getWinningMessage(LottoResult lottoResult, Winning winning) {
        final long winningCount = lottoResult.getCountOf(winning);
        final String bonusBallMessage = winning.needBonus() ? ", 보너스 볼 일치" : "";
        return String.format("%d개 일치%s (%s원)- %d개",
                winning.getMatchCount(),
                bonusBallMessage,
                winning.getReward(),
                winningCount);
    }

    private void showReturnOnInvestment(double roi) {
        System.out.printf("총 수익률은 %.2f입니다.%n", roi);
    }
}
