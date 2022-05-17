package lotto.view;

import lotto.vo.Lotteries;
import lotto.vo.Lottery;
import lotto.vo.Number;
import lotto.vo.Result;

import java.util.Arrays;
import java.util.List;

public class Message {
    private Message() {
    }

    public static void printEnterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printBuyingLotteriesCount(Lotteries lotteries) {
        System.out.printf("%d개를 구매했습니다.%n", lotteries.size());
    }

    public static void printBuyingLotteries(Lotteries lotteries) {
        for (Lottery lottery : lotteries.list()) {
            printLotteryNumbers(lottery);
        }
    }

    private static void printLotteryNumbers(Lottery lottery) {
        List<Number> numbers = lottery.list();
        int[] array = new int[numbers.size()];
        int idx = 0;
        for (Number number : numbers) {
            array[idx++] = number.value();
        }
        System.out.println(Arrays.toString(array));
    }

    public static void printLineFeed() {
        System.out.println();
    }

    public static void printEnterLastWeeksWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
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

    public static void printLotteriesResult(Result result) {
        System.out.printf("%d개 일치 (%d원)- %d개%n", result.matches(), result.reward(), result.count());
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
}
