package lotto.view;

import lotto.model.Winning;
import lotto.model.Winnings;

public class ResultView {
    public void showWinningStatistics(Winnings winnings) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(getWinningMessage(winnings, Winning.FOURTH_PRIZE));
        System.out.println(getWinningMessage(winnings, Winning.THIRD_PRIZE));
        System.out.println(getWinningMessage(winnings, Winning.SECOND_PRIZE));
        System.out.println(getWinningMessage(winnings, Winning.FIRST_PRIZE));
    }

    private String getWinningMessage(Winnings winnings, Winning winning) {
        final long winningCount = winnings.getCountOf(winning);
        return String.format("%d개 일치 (%s원)- %d개",
                winning.getMatchCount(),
                winning.getReward(),
                winningCount);
    }

    public void showReturnOnInvestment(double roi) {
        System.out.printf("총 수익률은 %.2f입니다.%n", roi);
    }
}
