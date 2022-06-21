package lotto.view;

import lotto.model.*;
import lotto.model.Number;

import java.util.Arrays;
import java.util.List;

public class Message {
    private Message() {
    }

    public static void printEnterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printBuyingLotteriesCount(Receipt receipt) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", receipt.getManualGameCount(), receipt.getAutoGameCount());
    }

    public static void printBuyingLotteries(Receipt receipt) {
        for (Lottery lottery : receipt.getAllLottery()) {
            printLotteryNumbers(lottery);
        }
        printLineFeed();
    }

    private static void printLotteryNumbers(Lottery lottery) {
        List<Number> numbers = lottery.getNumbers();
        int[] array = new int[numbers.size()];
        int idx = 0;
        for (Number number : numbers) {
            array[idx++] = number.value();
        }
        System.out.println(Arrays.toString(array));
    }

    public static void printEnterLastWeeksWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printEnterBonusBallNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static void printWinningStatistics() {
        System.out.println("당첨 통계");
    }

    public static void printDottedLine(int appendCount) {
        StringBuilder sb = new StringBuilder();
        while (appendCount-- > 0) {
            sb.append("-");
        }
        System.out.println(sb);
    }

    public static void printLotteriesResult(Summary summary) {
        List<String> details = summary.winningDetails();
        for (String detail : details) {
            System.out.println(detail);
        }
    }

    public static void printLotteriesEarningsRate(double ratio) {
        System.out.printf("총 수익률은 %.2f입니다.", ratio);
        if (ratio < 1.0) {
            printLotteriesEarningsRateExplanation();
        }
        printLineFeed();
    }

    public static void printLotteriesEarningsRateExplanation() {
        System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    public static void printLineFeed() {
        System.out.println();
    }
}
