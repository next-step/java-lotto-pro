package lotto.view;

import lotto.*;

import static lotto.LotteryCalculator.LOTTO_TICKET_UNIT_PRICE;

public class ResultView {

    public static final int BREAK_EVEN_POINT = 1;
    public static final String TOTAL_YIELD = "총 수익률은 ";
    public static final String LOSS_MESSAGE = "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String REVENUE_MESSAGE = "입니다.(기준이 1이기 때문에 결과적으로 수익이라는 의미임)";
    public static final String BREAK_EVEN_POINT_MESSAGE = "입니다.(기준이 1이기 때문에 결과적으로 본전라는 의미임)";
    public static final String OUTPUT_START_MESSAGE = "당첨 통계";
    public static final String UNIT = "개";
    public static final String MATCH_THREE = "3개 일치 (5000원)- ";
    public static final String MATCH_FOUR = "4개 일치 (50000원)- ";
    public static final String MATCH_FIVE = "5개 일치 (1500000원)- ";
    public static final String MATCH_SIX = "6개 일치 (2000000000원)- ";

    public static void printWinningStatistics(int numberOfTicket, PurchaseLotteryTicket purchaseLotteryTicket, WinningNumber winningNumber) {
        LotteryResult lotteryResult = purchaseLotteryTicket.countMatchInAllTicket(winningNumber);
        System.out.println();
        System.out.println(OUTPUT_START_MESSAGE);
        System.out.println(MATCH_THREE + lotteryResult.getOrDefault(Rank.FOURTH, 0) + UNIT);
        System.out.println(MATCH_FOUR + lotteryResult.getOrDefault(Rank.THIRD, 0) + UNIT);
        System.out.println(MATCH_FIVE + lotteryResult.getOrDefault(Rank.SECOND, 0) + UNIT);
        System.out.println(MATCH_SIX + lotteryResult.getOrDefault(Rank.FIRST, 0) + UNIT);
        Money totalWinningMoney = new Money(lotteryResult.calculateTotalWinningMoney());
        Money paidMoney = new Money(LOTTO_TICKET_UNIT_PRICE * numberOfTicket);
        double yield = totalWinningMoney.calculateYield(paidMoney);
        printYield(yield);
    }

    private static void printYield(double yield) {
        if (yield < BREAK_EVEN_POINT) {
            System.out.println(TOTAL_YIELD + yield + LOSS_MESSAGE);
        }
        if (yield == BREAK_EVEN_POINT) {
            System.out.println(TOTAL_YIELD + yield + BREAK_EVEN_POINT_MESSAGE);
        }
        if (yield > BREAK_EVEN_POINT) {
            System.out.println(TOTAL_YIELD + yield + REVENUE_MESSAGE);
        }
    }
}
