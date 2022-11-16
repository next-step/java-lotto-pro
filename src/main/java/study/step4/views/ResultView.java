package study.step4.views;

import study.step4.models.*;

import java.util.Collections;

public class ResultView {
    private static final String PURCHASE_COUNT_DESCRIPTION = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    private static final String STATISTICS_DESCRIPTION = "당첨 통계\n---------";
    private static final String BONUS_BALL_MATCHING_DESCRIPTION = "보너스 볼 일치";
    private static final String MATCHING_RESULT_DESCRIPTION = "%d개 일치 %s(%d원)- %d개\n";
    private static final int PROFIT_STANDARD = 1;
    private static final String TOTAL_EARNING_RATE_DESCRIPTION = "총 수익률은 %.2f입니다.";
    private static final String UNDER_ONE_DESCRIPTION = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printIntegratedLottos(IntegratedLottos integratedLottos) {
        System.out.printf(PURCHASE_COUNT_DESCRIPTION, integratedLottos.manualSize(), integratedLottos.autoSize());
        printLottos(integratedLottos.getManualLottos());
        printLottos(integratedLottos.getAutoLottos());
    }

    private static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            Collections.sort(lotto.getLottoNumbers(), LottoNumber::compare);
            System.out.println(lotto);
        }
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
