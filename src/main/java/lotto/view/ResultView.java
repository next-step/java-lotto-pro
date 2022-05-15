package lotto.view;

import lotto.domain.LottoPrize;
import lotto.domain.LottoTickets;
import lotto.domain.Money;

import java.util.List;

import static lotto.constants.LottoGameConstant.PROFIT_CRITERIA;
import static lotto.constants.LottoGameMessage.*;

public class ResultView {
    public static void printCount(int count) {
        System.out.printf(PURCHASED_LOTTO_COUNT_INFORMATION, count);
        System.out.println();
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        lottoTickets.printLottoTickets();
        System.out.println();
    }

    public static void printStatistics(List<LottoPrize> matchResults, Money money) {
        printStatisticsHeader();
        printMatchResult(matchResults, LottoPrize.WIN_WITH_3_MATCHES);
        printMatchResult(matchResults, LottoPrize.WIN_WITH_4_MATCHES);
        printMatchResult(matchResults, LottoPrize.WIN_WITH_5_MATCHES);
        printMatchResult(matchResults, LottoPrize.WIN_WITH_FULL_MATCHES);
        printProfitRate(matchResults, money);
    }

    private static void printStatisticsHeader() {
        System.out.println();
        System.out.println(LOTTO_STATISTICS_INFORMATION_TITLE);
        System.out.println(DIVIDER);
    }

    private static void printMatchResult(List<LottoPrize> matchResults, LottoPrize rank) {
        int count = calculateMatchCount(matchResults, rank);
        String format = String.format(STATISTICS_PER_NUMBER_OF_MATCH, rank.getNumberOfMatch(), rank.getPrize(), count);
        System.out.println(format);
    }

    private static int calculateMatchCount(List<LottoPrize> matchResults, LottoPrize rank) {
        return (int) matchResults.stream()
                .filter(result -> result.equals(rank))
                .count();
    }

    private static void printProfitRate(List<LottoPrize> matchResults, Money money) {
        double profitRate = calculateProfitRate(matchResults, money);
        System.out.printf(TOTAL_PROFIT_RESULT, profitRate);
        if (profitRate < PROFIT_CRITERIA) {
            System.out.printf(TOTAL_PROFIT_DESCRIPTION, HAS_LOSS);
        }
        if (profitRate > PROFIT_CRITERIA) {
            System.out.printf(TOTAL_PROFIT_DESCRIPTION, HAS_PROFIT);
        }
        if (profitRate == PROFIT_CRITERIA) {
            System.out.printf(TOTAL_PROFIT_DESCRIPTION, HAS_NOTHING);
        }
    }

    private static double calculateProfitRate(List<LottoPrize> matchResults, Money money) {
        int totalWinningPrize = matchResults.stream()
                .mapToInt(LottoPrize::getPrize).sum();

        return (totalWinningPrize * 1.0) / (money.getMoney() * 1.0);
    }
}
