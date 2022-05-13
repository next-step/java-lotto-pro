package lotto.view;

import java.util.List;

import lotto.domain.LottoGroups;
import lotto.domain.Money;
import lotto.domain.Rank;

public class ResultView {
    private static final String BUY_MESSAGE_FORMAT = "%d개를 구매했습니다.%n";
    private static final String MATCH_RESULT_MESSAGE_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String STATISTICS_MESSAGE_HEADER = "당첨 통계";
    private static final String STATISTICS_MESSAGE_DELIMITER = "---------";
    private static final String PROFIT_RATE_MESSAGE_FORMAT = "총 수익률은 %.2f입니다.";
    private static final String LOSS_MESSAGE_FORMAT = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final int PROFIT_STANDARD_VALUE = 1;

    public static void printCount(int count) {
        System.out.printf(BUY_MESSAGE_FORMAT, count);
    }

    public static void printLottoGroups(LottoGroups lottoGroups) {
        lottoGroups.printLottoGroups();
    }

    public static void printStatistics(List<Rank> matchResults, Money money) {
        printStatisticsHeader();
        printMatchResult(matchResults, Rank.FIFTH);
        printMatchResult(matchResults, Rank.FOURTH);
        printMatchResult(matchResults, Rank.THIRD);
        printMatchResult(matchResults, Rank.FIRST);
        printProfitRate(matchResults, money);
    }

    private static void printStatisticsHeader() {
        System.out.println();
        System.out.println(STATISTICS_MESSAGE_HEADER);
        System.out.println(STATISTICS_MESSAGE_DELIMITER);
    }

    private static void printMatchResult(List<Rank> matchResults, Rank rank) {
        int count = calculateMatchCount(matchResults, rank);
        String format = String.format(MATCH_RESULT_MESSAGE_FORMAT, rank.getMatchCount(), rank.getWinningPrize(), count);
        System.out.println(format);
    }

    private static int calculateMatchCount(List<Rank> matchResults, Rank rank) {
        return (int) matchResults.stream()
                .filter(result -> result.equals(rank))
                .count();
    }

    private static void printProfitRate(List<Rank> matchResults, Money money) {
        double profitRate = calculateProfitRate(matchResults, money);
        System.out.printf(PROFIT_RATE_MESSAGE_FORMAT, profitRate);
        if (profitRate < PROFIT_STANDARD_VALUE) {
            System.out.println(LOSS_MESSAGE_FORMAT);
        }
    }

    private static double calculateProfitRate(List<Rank> matchResults, Money money) {
        int totalWinningPrize = matchResults.stream()
                .mapToInt(Rank::getWinningPrize).sum();
        return (totalWinningPrize * 1.0) / (money.getMoney() * 1.0);
    }
}
