package lotto.ui;

import lotto.domain.*;

import java.util.List;
import java.util.Map;

public class ResultView {

    private ResultView() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(String message, Object... args) {
        System.out.printf(message, args);
        newLine();
    }

    public static void newLine() {
        System.out.println();
    }

    public static void printStatisticsResult(final StatisticsResult statisticsResult) {
        for (Map.Entry<Rank, Integer> countOfRanks : statisticsResult.getCountsOfRanks().entrySet()) {
            printCountOfRanks(countOfRanks);
        }
        ResultView.printMessage(ConsoleMessage.OUTPUT_YIELDS.getMessage(), statisticsResult.getYields().getValue());
    }

    private static void printCountOfRanks(final Map.Entry<Rank, Integer> rankToCount) {
        Rank rank = rankToCount.getKey();
        if (rank == Rank.MISS) {
            return;
        }
        ResultView.printMessage(createCountOfRanksMessage(rankToCount));
    }

    private static String createCountOfRanksMessage(final Map.Entry<Rank, Integer> rankToCount) {
        Rank rank = rankToCount.getKey();
        MatchCount expectedMatchCount = rank.getMatchCount();
        Integer realMatchCount = rankToCount.getValue();
        if (rank == Rank.SECOND) {
            return String.format(ConsoleMessage.OUTPUT_WINNING_BONUS_RESULT.getMessage(),
                    expectedMatchCount.getMatchBallCount(), rank.getWinningMoney(), realMatchCount);
        }
        return String.format(ConsoleMessage.OUTPUT_WINNING_RESULT.getMessage(),
                expectedMatchCount.getMatchBallCount(), rank.getWinningMoney(), realMatchCount);
    }

    public static void printWinningStatistics() {
        printMessage(ConsoleMessage.OUTPUT_WINNING_RESULT_TITLE.getMessage());
    }

    public static void printPurchasedLottos(final List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printMessage(lotto.toString());
        }
    }

    public static void printQuantity(final Quantity quantity) {
        String message = String.format(
                ConsoleMessage.OUTPUT_PURCHASE_COMPLETE.getMessage(),
                quantity.getCount(PurchaseType.MANUAL),
                quantity.getCount(PurchaseType.AUTO)
        );

        ResultView.printMessage(message);
    }
}
