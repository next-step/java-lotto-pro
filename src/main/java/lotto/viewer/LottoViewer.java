package lotto.viewer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.constants.Matched;
import lotto.domain.Lottos;
import lotto.domain.LottosWinningStatistics;
import lotto.domain.Price;

public class LottoViewer {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_PRICE_ERROR_MESSAGE = "오직 정수만 입력할 수 있습니다.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String PURCHASE_NOTICE_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_TITLE_MESSAGE = "당첨 통계";
    private static final String BOUNDARY_MESSAGE = "---------";
    private static final Scanner scanner = new Scanner(System.in);

    private LottoViewer() {
    }

    public static Price inputPrice() {
        printMessage(INPUT_PRICE_MESSAGE);
        int price;
        try {
            price = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INPUT_PRICE_ERROR_MESSAGE);
        }
        return new Price(price);
    }

    public static String inputWinningNumbers() {
        printMessage(INPUT_WINNING_NUMBERS_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputBonusNumber() {
        printMessage(INPUT_BONUS_NUMBER_MESSAGE);
        return scanner.nextLine();
    }

    public static void printLottos(final Lottos lottos) {
        printFormatMessage(PURCHASE_NOTICE_MESSAGE, lottos.getLottosCount());
        final String[] lottosString = lottos.getLottos()
                .stream()
                .map(lotto -> makeLottoString(lotto.getNumbers()))
                .toArray(String[]::new);
        for (final String lottoString : lottosString) {
            printMessage(lottoString);
        }
    }

    private static String makeLottoString(final List<Integer> numbers) {
        final StringBuilder builder = new StringBuilder();
        for (Integer number : numbers) {
            builder.append(" ")
                    .append(number)
                    .append(",");
        }
        return "[" + builder.substring(1, builder.length() - 1) + "]";
    }

    public static void printMessage(final String message) {
        System.out.println(message);
    }

    private static void printFormatMessage(final String format, Object... args) {
        System.out.printf(format, args);
        System.out.println();
    }

    public static void printStatistics(final LottosWinningStatistics lottosWinningStatistics) {
        printMessage(WINNING_STATISTICS_TITLE_MESSAGE);
        printMessage(BOUNDARY_MESSAGE);

        final List<String> stringList = new ArrayList<>();
        final int threeMatchedCount = lottosWinningStatistics.getWinningMatchedCount(Matched.THREE_MATCHED.getCount());
        final int fourMatchedCount = lottosWinningStatistics.getWinningMatchedCount(Matched.FOUR_MATCHED.getCount());
        final int onlyFiveMatchedCount = lottosWinningStatistics.getWinningMatchedCountUsingBonus(Matched.FIVE_MATCHED.getCount(), false);
        final int fiveAndBonusMatchedCount = lottosWinningStatistics.getWinningMatchedCountUsingBonus(Matched.FIVE_MATCHED.getCount(), true);
        final int sixMatchedCount = lottosWinningStatistics.getWinningMatchedCount(Matched.SIX_MATCHED.getCount());
        final int totalReward = lottosWinningStatistics.calculateTotalReward(lottosWinningStatistics.getWinningMatches());
        final Price price = lottosWinningStatistics.getPrice();

        stringList.add("3개 일치 (5000원)- " + threeMatchedCount + "개");
        stringList.add("4개 일치 (50000원)- " + fourMatchedCount + "개");
        stringList.add("5개 일치 (1500000원)- " + onlyFiveMatchedCount + "개");
        stringList.add("5개 일치, 보너스 볼 일치(30000000원)- " + fiveAndBonusMatchedCount + "개");
        stringList.add("6개 일치 (2000000000원)- " + sixMatchedCount + "개");
        stringList.add("총 수익률은 " + String.format("%.2f", price.calculateYield(totalReward)) + "입니다.");

        final String[] statisticsString =  stringList.toArray(new String[0]);

        for (final String statisticString : statisticsString) {
            printMessage(statisticString);
        }
    }
}
