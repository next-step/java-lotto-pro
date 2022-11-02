package lotto.ui;

import lotto.domain.*;

import java.util.List;
import java.util.Map;

public class ResultView {

    private final Output output;

    public ResultView(Output output) {
        this.output = output;
    }

    public void printMessage(String message) {
        output.printMessage(message);
    }

    public void printStatisticsResult(final StatisticsResult statisticsResult) {
        for (Map.Entry<Rank, Integer> countOfRanks : statisticsResult.getCountsOfRanks().entrySet()) {
            printCountOfRanks(countOfRanks);
        }
        output.printMessage(ConsoleMessage.OUTPUT_YIELDS.getMessage(), statisticsResult.getYields().getValue());
    }

    private void printCountOfRanks(final Map.Entry<Rank, Integer> rankToCount) {
        Rank rank = rankToCount.getKey();
        if (rank == Rank.MISS) {
            return;
        }
        output.printMessage(createCountOfRanksMessage(rankToCount));
    }

    private String createCountOfRanksMessage(final Map.Entry<Rank, Integer> rankToCount) {
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

    public void printWinningStatistics() {
        output.printMessage(ConsoleMessage.OUTPUT_WINNING_RESULT_TITLE.getMessage());
    }

    public void printPurchasedLottos(final List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            output.printMessage(lotto.toString());
        }
    }

    public void printQuantity(final Quantity quantity) {
        String message = String.format(
                ConsoleMessage.OUTPUT_PURCHASE_COMPLETE.getMessage(),
                quantity.getCount(PurchaseType.MANUAL),
                quantity.getCount(PurchaseType.AUTO)
        );

        output.printMessage(message);
    }
}
