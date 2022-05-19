package lotto;

import lotto.domain.*;
import lotto.view.Console;
import lotto.view.Message;

public class LotteryGame {
    public static void main(String[] args) {
        Money money = readMoney();
        Lotteries lotteries = buyLotteries(money);
        Lottery winning = readLastWeeksWinningNumbers();
        printSummary(money, winning, lotteries);
    }

    private static Lotteries buyLotteries(Money money) {
        Lotteries lotteries = exchangeCouponToLotteries(exchangeMoneyToTicket(money));
        printBuyingLotteriesCount(lotteries);
        printBuyingLotteries(lotteries);
        return lotteries;
    }

    private static Money readMoney(){
        try {
            Message.printEnterPurchaseAmount();
            return Console.readMoney();
        } catch (NumberFormatException ignored) {
            return readMoney();
        }
    }

    private static Ticket exchangeMoneyToTicket(Money money) {
        try {
            return LotteryClerk.exchangeTicket(money);
        } catch (IllegalArgumentException ignored) {
            return exchangeMoneyToTicket(readMoney());
        }
    }

    private static Lotteries exchangeCouponToLotteries(Ticket ticket) {
        return LotteryStore.exchangeTicketToLotteries(ticket);
    }

    private static void printBuyingLotteriesCount(Lotteries lotteries) {
        Message.printBuyingLotteriesCount(lotteries);
    }

    private static void printBuyingLotteries(Lotteries lotteries) {
        Message.printBuyingLotteries(lotteries);
        Message.printLineFeed();
    }

    private static Lottery readLastWeeksWinningNumbers() {
        try {
            Message.printEnterLastWeeksWinningNumbers();
            return Console.readLastWeeksWinningNumbers();
        } catch (IllegalArgumentException ignored) {
            return readLastWeeksWinningNumbers();
        }
    }

    private static void printSummary(Money money, Lottery winning, Lotteries lotteries) {
        printWinningStatistics();
        printDottedLine();
        Summary summary = createWinningDetails(winning, lotteries);
        printLotteriesResult(summary);
        printLotteriesEarningsRate(summary, money);
    }

    private static void printWinningStatistics() {
        Message.printWinningStatistics();
    }

    private static void printDottedLine() {
        Message.printDottedLine(9);
    }

    private static Summary createWinningDetails(Lottery winning, Lotteries lotteries) {
        return LotterySummary.createWinningDetails(winning, lotteries);
    }

    private static void printLotteriesResult(Summary summary) {
        for (Result result : summary.list()) {
            Message.printLotteriesResult(result);
        }
    }

    private static void printLotteriesEarningsRate(Summary summary, Money money) {
        Message.printLotteriesEarningsRate(YieldCalculator.earningsRate(summary, money));
    }
}
