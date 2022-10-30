package lotto;

import static lotto.Constant.BOUGHT_SOME;
import static lotto.Constant.DIVIDING_LINE;
import static lotto.Constant.EA;
import static lotto.Constant.HIT_FIVE;
import static lotto.Constant.HIT_FOUR;
import static lotto.Constant.HIT_SIX;
import static lotto.Constant.HIT_THREE;
import static lotto.Constant.PRIZE_OF_FIRST;
import static lotto.Constant.PRIZE_OF_FOURTH;
import static lotto.Constant.PRIZE_OF_SECOND;
import static lotto.Constant.PRIZE_OF_THIRD;
import static lotto.Constant.WINNING_STATISTICS;

import java.util.List;

public class ResultView {
    void resultPay(int purchaseCount) {
        System.out.println(purchaseCount + BOUGHT_SOME);
    }

    void resultPurchase(List<LottoNumber> lottoNumbers) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }

    void resultWinningStatistics(int payMoney, Prize prize) {
        printWinningCount(prize);
        printResultTotalEarningsRate(calculateTotalEarningsRate(payMoney, calculateTotalEarnings(prize)));
    }

    private void printWinningCount(Prize prize) {
        System.out.println("\n" + WINNING_STATISTICS);
        System.out.println(DIVIDING_LINE);
        System.out.println(HIT_THREE + prize.getCountOfFourth() + EA);
        System.out.println(HIT_FOUR + prize.getCountOfThird() + EA);
        System.out.println(HIT_FIVE + prize.getCountOfSecond() + EA);
        System.out.println(HIT_SIX + prize.getCountOfFirst() + EA);
    }

    private void printResultTotalEarningsRate(int totalEarningsRate) {
        System.out.println("총 수익률은 " + totalEarningsRate + "입니다.");
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
