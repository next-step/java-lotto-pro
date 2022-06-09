package lotto;

import lotto.model.Number;
import lotto.model.*;
import lotto.service.LotteryStore;
import lotto.service.LotterySummary;
import lotto.service.YieldCalculator;
import lotto.view.Console;
import lotto.view.Message;

import java.util.LinkedList;
import java.util.List;

public class LotteryGame {
    public static void main(String[] args) {
        Receipt receipt = new Receipt(readMoney());
        buyGames(receipt);
        Lottery numbers = readLastWeeksWinningNumbers();
        Winning details = readWinningDetails(numbers);
        printSummary(receipt, details);
    }

    private static Money readMoney(){
        try {
            Message.printEnterPurchaseAmount();
            Money money = Console.readMoney();
            Message.printLineFeed();
            return money;
        } catch (IllegalArgumentException ignored) {
            return readMoney();
        }
    }

    private static void buyGames(Receipt receipt) {
        int count = readManualGameCount();
        if (count > 0) {
            receipt.addManualGames(readManualNumbers(count));

        }
        receipt.addAutoGames(LotteryStore.exchangeToLotteries(receipt.getTicket()));
        Message.printLineFeed();
        Message.printBuyingLotteriesCount(receipt);
        Message.printBuyingLotteries(receipt);
    }

    private static int readManualGameCount() {
        try {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            return Console.readManualGameCount();
        } catch (NumberFormatException ignored) {
            return readManualGameCount();
        }
    }

    private static Lotteries readManualNumbers(int count) {
        List<Lottery> lotteries = new LinkedList<>();
        while (count > 0) {
            try {
                lotteries.add(Console.readNumbers());
                count--;
            } catch (Exception ignored) {
            }
        }
        return new Lotteries(lotteries);
    }

    private static Lottery readLastWeeksWinningNumbers() {
        try {
            Message.printEnterLastWeeksWinningNumbers();
            return Console.readNumbers();
        } catch (IllegalArgumentException ignored) {
            return readLastWeeksWinningNumbers();
        }
    }

    private static Winning readWinningDetails(Lottery numbers) {
        Number bonus = readBonusNumber();
        try {
            Winning winning = new Winning(numbers, bonus);
            Message.printLineFeed();
            return winning;
        } catch (IllegalArgumentException ignored) {
            return readWinningDetails(numbers);
        }
    }

    private static Number readBonusNumber() {
        try {
            Message.printEnterBonusBallNumber();
            return Console.readBonusNumber();
        } catch (IllegalArgumentException ignored) {
            return readBonusNumber();
        }
    }

    private static void printSummary(Receipt receipt, Winning details) {
        Message.printWinningStatistics();
        Message.printDottedLine(9);
        Summary summary = LotterySummary.createDetails(details, receipt.getBuyingGames());
        Message.printLotteriesResult(summary);
        Message.printLotteriesEarningsRate(YieldCalculator.earningsRate(summary, receipt.getMoney()));
    }
}
