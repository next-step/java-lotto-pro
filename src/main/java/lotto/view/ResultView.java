package lotto.view;

import static lotto.common.ViewMessage.BUY_MESSAGE;
import static lotto.common.ViewMessage.LOSS_MESSAGE;
import static lotto.common.ViewMessage.MATCH_RESULT_MESSAGE;
import static lotto.common.ViewMessage.MATCH_RESULT_WITH_BONUS_MESSAGE;
import static lotto.common.ViewMessage.PROFIT_RATE_MESSAGE;
import static lotto.common.ViewMessage.STATISTICS_MESSAGE_HEADER;

import java.util.List;

import lotto.common.ViewMessage;
import lotto.domain.LottoCount;
import lotto.domain.LottoGroups;
import lotto.domain.Money;
import lotto.domain.Rank;

public class ResultView {
    private static final int PROFIT_STANDARD_VALUE = 1;

    public static void printCount(LottoCount manualLottoCount, Money money) {
        System.out.printf(BUY_MESSAGE.getMessage(), manualLottoCount.getCount(), manualLottoCount.calculateAutoLottoCount(money));
    }

    public static void printLottoGroups(LottoGroups lottoGroups) {
        lottoGroups.printLottoGroups();
        System.out.println();
    }

    public static void printStatistics(List<Rank> matchResults, Money money) {
        printStatisticsHeader();
        printMatchResult(matchResults, Rank.FIFTH);
        printMatchResult(matchResults, Rank.FOURTH);
        printMatchResult(matchResults, Rank.THIRD);
        printMatchResultWithBonus(matchResults);
        printMatchResult(matchResults, Rank.FIRST);
        printProfitRate(matchResults, money);
    }

    private static void printStatisticsHeader() {
        System.out.println();
        System.out.println(STATISTICS_MESSAGE_HEADER.getMessage());
    }

    private static void printMatchResult(List<Rank> matchResults, Rank rank) {
        int count = calculateMatchCount(matchResults, rank);
        String format = String.format(MATCH_RESULT_MESSAGE.getMessage(), rank.getMatchCount(), rank.getWinningPrize(), count);
        System.out.println(format);
    }

    private static void printMatchResultWithBonus(List<Rank> matchResults) {
        int count = calculateMatchCount(matchResults, Rank.SECOND);
        String format = String.format(MATCH_RESULT_WITH_BONUS_MESSAGE.getMessage(), Rank.SECOND.getMatchCount(), Rank.SECOND.getWinningPrize(), count);
        System.out.println(format);
    }

    private static int calculateMatchCount(List<Rank> matchResults, Rank rank) {
        return (int) matchResults.stream()
                .filter(result -> result.equals(rank))
                .count();
    }

    private static void printProfitRate(List<Rank> matchResults, Money money) {
        double profitRate = calculateProfitRate(matchResults, money);
        System.out.printf(PROFIT_RATE_MESSAGE.getMessage(), profitRate);
        if (profitRate < PROFIT_STANDARD_VALUE) {
            System.out.println(LOSS_MESSAGE.getMessage());
        }
    }

    private static double calculateProfitRate(List<Rank> matchResults, Money money) {
        int totalWinningPrize = matchResults.stream()
                .mapToInt(Rank::getWinningPrize).sum();
        return (totalWinningPrize * 1.0) / (money.getMoney() * 1.0);
    }
}
