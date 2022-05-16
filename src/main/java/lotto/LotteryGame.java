package lotto;

import lotto.view.Console;
import lotto.view.Message;
import lotto.vo.*;

public class LotteryGame {
    private static Money money;
    private static Coupon coupon;
    private static Lotteries lotteries;
    private static Lottery winning;
    private static Winning result;

    public static void main(String[] args) {
        readMoney();

        exchangeMoneyToCoupon();

        exchangeCouponToLotteries();

        printBuyingLotteriesCount();

        printBuyingLotteries();

        readLastWeeksWinningNumbers();

        printWinningStatistics();

        printDottedLine();

        countMatches();

        printLotteriesResult();

        printLotteriesEarningsRate();
    }

    private static void readMoney(){
        try {
            Message.printEnterPurchaseAmount();
            money = Console.readMoney();
        } catch (NumberFormatException ignored) {
            readMoney();
        }
    }

    private static void exchangeMoneyToCoupon() {
        try {
            coupon = LotteryClerk.exchangeCoupon(money);
        } catch (IllegalArgumentException ignored) {
            readMoney();
            exchangeMoneyToCoupon();
        }
    }

    private static void exchangeCouponToLotteries() {
        lotteries = LotteryStore.exchangeCouponToLotteries(coupon);
    }

    private static void printBuyingLotteriesCount() {
        Message.printBuyingLotteriesCount(lotteries);
    }

    private static void printBuyingLotteries() {
        Message.printBuyingLotteries(lotteries);
        Message.printLineFeed();
    }

    private static void readLastWeeksWinningNumbers() {
        try {
            Message.printEnterLastWeeksWinningNumbers();
            winning = Console.readLastWeeksWinningNumbers();
        } catch (IllegalArgumentException ignored) {
            readLastWeeksWinningNumbers();
        }
    }

    private static void printWinningStatistics() {
        Message.printWinningStatistics();
    }

    private static void printDottedLine() {
        Message.printDottedLine(9);
    }

    private static void countMatches() {
        LotteryStatistics.countMatches(winning, lotteries);
        result = LotteryStatistics.result();
    }

    private static void printLotteriesResult() {
        for (Result result : result.list()) {
            Message.printLotteriesResult(result);
        }
    }

    private static void printLotteriesEarningsRate() {
        Message.printLotteriesEarningsRate(LotteryStatistics.earningsRate(result, money));
    }
}
