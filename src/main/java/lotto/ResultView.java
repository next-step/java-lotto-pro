/*
 * ResultView.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import static lotto.Constant.EA;
import static lotto.Constant.RESULT_BOUGHT_SOME;
import static lotto.Constant.RESULT_DIVIDING_LINE;
import static lotto.Constant.RESULT_HIT_FIVE;
import static lotto.Constant.RESULT_HIT_FOUR;
import static lotto.Constant.RESULT_HIT_SIX;
import static lotto.Constant.RESULT_HIT_THREE;
import static lotto.Constant.RESULT_TOTAL_EARNINGS_RATE_1;
import static lotto.Constant.RESULT_TOTAL_EARNINGS_RATE_2;
import static lotto.Constant.RESULT_WINNING_STATISTICS;

import java.util.List;

public class ResultView {
    void printResultPay(int purchaseCount) {
        System.out.println(purchaseCount + RESULT_BOUGHT_SOME);
    }

    void printResultPurchase(List<LottoNumber> lottoNumbers) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }

    void printResultWinningStatistics(int payMoney, Statistic statistic) {
        printWinningCount(statistic);
        printResultTotalEarningsRate(calculateTotalEarningsRate(payMoney, calculateTotalEarnings(statistic)));
    }

    private void printWinningCount(Statistic statistic) {
        System.out.println("\n" + RESULT_WINNING_STATISTICS);
        System.out.println(RESULT_DIVIDING_LINE);
        System.out.println(RESULT_HIT_THREE + statistic.getCountOfFourth() + EA);
        System.out.println(RESULT_HIT_FOUR + statistic.getCountOfThird() + EA);
        System.out.println(RESULT_HIT_FIVE + statistic.getCountOfSecond() + EA);
        System.out.println(RESULT_HIT_SIX + statistic.getCountOfFirst() + EA);
    }

    private void printResultTotalEarningsRate(int totalEarningsRate) {
        System.out.println(RESULT_TOTAL_EARNINGS_RATE_1 + totalEarningsRate + RESULT_TOTAL_EARNINGS_RATE_2);
    }

    private int calculateTotalEarningsRate(int payMoney, int totalEarnings) {
        return totalEarnings / payMoney;
    }

    private int calculateTotalEarnings(Statistic statistic) {
        return Prize.FOURTH.getPrize() * statistic.getCountOfFourth()
                + Prize.THIRD.getPrize() * statistic.getCountOfThird()
                + Prize.SECOND.getPrize() * statistic.getCountOfSecond()
                + Prize.FIRST.getPrize() * statistic.getCountOfFirst();
    }
}
