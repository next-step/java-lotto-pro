/*
 * ResultView.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import static lotto.Constant.EA;
import static lotto.Constant.RESULT_BOUGHT_1;
import static lotto.Constant.RESULT_BOUGHT_2;
import static lotto.Constant.RESULT_BOUGHT_3;
import static lotto.Constant.RESULT_HIT_FIVE;
import static lotto.Constant.RESULT_HIT_FIVE_AND_BONUS;
import static lotto.Constant.RESULT_HIT_FOUR;
import static lotto.Constant.RESULT_HIT_SIX;
import static lotto.Constant.RESULT_HIT_THREE;
import static lotto.Constant.RESULT_TOTAL_EARNINGS_RATE_1;
import static lotto.Constant.RESULT_TOTAL_EARNINGS_RATE_2;
import static lotto.Constant.RESULT_WINNING_STATISTICS;

public class ResultView {
    void printResultPay(Quantity autoQuantity, Quantity manualQuantity) {
        System.out.println(
                RESULT_BOUGHT_1 + manualQuantity.getQuantity() + RESULT_BOUGHT_2
                        + autoQuantity.getQuantity() + RESULT_BOUGHT_3);
    }

    void printResultPurchase(Lottos lottos) {
        System.out.println(lottos.printPurchaseLottoNumber());
    }

    void printResultWinningStatistics(int payMoney, Statistic statistic) {
        printWinningCount(statistic);
        printResultTotalEarningsRate(statistic.calculateTotalEarningsRate(payMoney));
    }

    private void printWinningCount(Statistic statistic) {
        System.out.println("\n" + RESULT_WINNING_STATISTICS);
        System.out.println(RESULT_HIT_THREE + statistic.getCountOfFifth() + EA);
        System.out.println(RESULT_HIT_FOUR + statistic.getCountOfFourth() + EA);
        System.out.println(RESULT_HIT_FIVE + statistic.getCountOfThird() + EA);
        System.out.println(RESULT_HIT_FIVE_AND_BONUS + statistic.getCountOfSecond() + EA);
        System.out.println(RESULT_HIT_SIX + statistic.getCountOfFirst() + EA);
    }

    private void printResultTotalEarningsRate(double totalEarningsRate) {
        System.out.println(RESULT_TOTAL_EARNINGS_RATE_1 + totalEarningsRate + RESULT_TOTAL_EARNINGS_RATE_2);
    }
}
