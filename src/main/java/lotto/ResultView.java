/*
 * ResultView.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import static lotto.Constant.EA;
import static lotto.Constant.PRIZE_OF_FIRST;
import static lotto.Constant.PRIZE_OF_FOURTH;
import static lotto.Constant.PRIZE_OF_SECOND;
import static lotto.Constant.PRIZE_OF_THIRD;
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

class ResultView {
    void printResultPay(int purchaseCount) {
        System.out.println(purchaseCount + RESULT_BOUGHT_SOME);
    }

    void printResultPurchase(List<LottoNumber> lottoNumbers) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }

    void printResultWinningStatistics(int payMoney, Prize prize) {
        printWinningCount(prize);
        printResultTotalEarningsRate(calculateTotalEarningsRate(payMoney, calculateTotalEarnings(prize)));
    }

    private void printWinningCount(Prize prize) {
        System.out.println("\n" + RESULT_WINNING_STATISTICS);
        System.out.println(RESULT_DIVIDING_LINE);
        System.out.println(RESULT_HIT_THREE + prize.getCountOfFourth() + EA);
        System.out.println(RESULT_HIT_FOUR + prize.getCountOfThird() + EA);
        System.out.println(RESULT_HIT_FIVE + prize.getCountOfSecond() + EA);
        System.out.println(RESULT_HIT_SIX + prize.getCountOfFirst() + EA);
    }

    private void printResultTotalEarningsRate(int totalEarningsRate) {
        System.out.println(RESULT_TOTAL_EARNINGS_RATE_1 + totalEarningsRate + RESULT_TOTAL_EARNINGS_RATE_2);
    }

    private int calculateTotalEarningsRate(int payMoney, int totalEarnings) {
        return totalEarnings / payMoney;
    }

    private int calculateTotalEarnings(Prize prize) {
        return PRIZE_OF_FOURTH * prize.getCountOfFourth()
                + PRIZE_OF_THIRD * prize.getCountOfThird()
                + PRIZE_OF_SECOND * prize.getCountOfSecond()
                + PRIZE_OF_FIRST * prize.getCountOfFirst();
    }
}
