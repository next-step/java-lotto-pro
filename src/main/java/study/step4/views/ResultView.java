package study.step4.views;

import study.step4.models.Rank;
import study.step4.models.Lottos;
import study.step4.models.Money;
import study.step4.models.Winners;

public class ResultView {
    private static final String PURCHASE_COUNT_DESCRIPTION = "%d개를 구매했습니다.\n";
    private static final String STATISTICS_DESCRIPTION = "당첨 통계\n---------";
    private static final String BONUS_BALL_MATCHING_DESCRIPTION = "보너스 볼 일치";
    private static final String MATCHING_RESULT_DESCRIPTION = "%d개 일치 %s(%d원)- %d개\n";
    private static final int PROFIT_STANDARD = 1;
    private static final String TOTAL_EARNING_RATE_DESCRIPTION = "총 수익률은 %.2f입니다.";
    private static final String UNDER_ONE_DESCRIPTION = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printLottos(Lottos lottos) {
        System.out.printf(PURCHASE_COUNT_DESCRIPTION, lottos.size());
        lottos.printAll();
    }

    public static void printLottoWinners(Winners winners) {
        System.out.println(STATISTICS_DESCRIPTION);
        for (Rank rank : Rank.values()) {
            printMatchingResult(winners, rank);
        }
    }

    private static void printMatchingResult(Winners winners, Rank rank) {
        if (rank.isWinningRank())
            System.out.printf(MATCHING_RESULT_DESCRIPTION
                    , rank.getNumberOfMatching()
                    , rank.hasBonusBallNumber() ? BONUS_BALL_MATCHING_DESCRIPTION : ""
                    , rank.getReward()
                    , winners.numberOfRankers(rank));
    }

    public static void printEarningRate(Winners winners, Money money) {
        String description = TOTAL_EARNING_RATE_DESCRIPTION;
        double earningRate = winners.earningRate(money);
        if (earningRate < PROFIT_STANDARD) {
            description += UNDER_ONE_DESCRIPTION;
        }
        System.out.printf(description + "\n", earningRate);
    }
}
