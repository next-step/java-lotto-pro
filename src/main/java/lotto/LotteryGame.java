package lotto;

import lotto.model.*;
import lotto.model.Number;
import lotto.service.LotteryClerk;
import lotto.service.LotteryStore;
import lotto.service.LotterySummary;
import lotto.service.YieldCalculator;
import lotto.view.Console;
import lotto.view.Message;

public class LotteryGame {
    public static void main(String[] args) {
        Money money = readMoney();
        Lotteries purchase = buyLotteries(money);
        Lottery numbers = readLastWeeksWinningNumbers();
        Winning details = readWinningDetails(numbers);
        printSummary(money, details, purchase);
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

    private static Winning readWinningDetails(Lottery numbers) {
        Number bonus = readBonusBallNumber();
        try {
            return new Winning(numbers, bonus);
        } catch (IllegalArgumentException ignored) {
            return readWinningDetails(numbers);
        }
    }

    private static Number readBonusBallNumber() {
        try {
            Message.printEnterBonusBallNumber();
            return Console.readBonusBallNumber();
        } catch (IllegalArgumentException ignored) {
            return readBonusBallNumber();
        }
    }

    private static void printSummary(Money money, Winning details, Lotteries purchase) {
        printWinningStatistics();
        printDottedLine();
        Summary summary = createDetails(details, purchase);
        printLotteriesResult(summary);
        printLotteriesEarningsRate(summary, money);
    }

    private static void printWinningStatistics() {
        Message.printWinningStatistics();
    }

    private static void printDottedLine() {
        Message.printDottedLine(9);
    }

    private static Summary createDetails(Winning details, Lotteries purchase) {
        return LotterySummary.createDetails(details, purchase);
    }

    private static void printLotteriesResult(Summary summary) {
        Message.printLotteriesResult(summary);
    }

    private static void printLotteriesEarningsRate(Summary summary, Money money) {
        Message.printLotteriesEarningsRate(YieldCalculator.earningsRate(summary, money));
    }
}
