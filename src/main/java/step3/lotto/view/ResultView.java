package step3.lotto.view;

import step3.lotto.domain.lotto.MatchResult;
import step3.lotto.domain.lotto.MatchStatistic;

/**
 * @author : choi-ys
 * @date : 2022/05/17 2:09 오후
 */
public class ResultView {

    private static final String WINNING_STATISTICS_TITLE_GUIDE_MESSAGE = "당첨 통계";
    private static final String RESULT_MESSAGE_SEPARATOR_LINE = "---------\n";
    private static final String WINNING_STATISTICS_TITLE_GUIDE_MESSAGE_FORMAT = String.format(
        "%s\n%s",
        WINNING_STATISTICS_TITLE_GUIDE_MESSAGE,
        RESULT_MESSAGE_SEPARATOR_LINE
    );
    private static final String STATISTICS_GUIDE_MESSAGE = "%s개 일치 (%d원)- %d개\n";
    private static final String SECOND_PLACE_STATISTICS_GUIDE_MESSAGE = "%s개 일치, 보너스볼 일치 (%d원)- %d개\n";
    private static final String RATE_OF_PROFIT_GUIDE_MESSAGE = "총 수익률은 %.2f입니다.";

    private static final StringBuffer stringBuffer = new StringBuffer();

    public static void printWinningStatistics(MatchStatistic matchStatistic) {
        System.out.println();
        stringBuffer.append(WINNING_STATISTICS_TITLE_GUIDE_MESSAGE_FORMAT);
        addStatisticsContent(matchStatistic);
        stringBuffer.append(String.format(RATE_OF_PROFIT_GUIDE_MESSAGE, matchStatistic.getRateOfProfit()));
        System.out.println(stringBuffer.toString());
    }

    private static void addStatisticsContent(MatchStatistic matchStatistic) {
        stringBuffer.append(statisticsFormat(MatchResult.FIFTH_PLACE, matchStatistic.getFifthPlaceCount()));
        stringBuffer.append(statisticsFormat(MatchResult.FORTH_PLACE, matchStatistic.getForthPlaceCount()));
        stringBuffer.append(statisticsFormat(MatchResult.THIRD_PLACE, matchStatistic.getThirdPlaceCount()));
        stringBuffer.append(secondPlaceStatisticFormat(MatchResult.SECOND_PLACE, matchStatistic.getSecondPlaceCount()));
        stringBuffer.append(statisticsFormat(MatchResult.FIRST_PLACE, matchStatistic.getFirstPlaceCount()));
    }

    private static String statisticsFormat(MatchResult matchResult, int winningCount) {
        return String.format(
            STATISTICS_GUIDE_MESSAGE,
            matchResult.getMatchCount(),
            matchResult.getRewardPrice(),
            winningCount
        );
    }

    private static String secondPlaceStatisticFormat(MatchResult matchResult, int winningCount) {
        return String.format(
            SECOND_PLACE_STATISTICS_GUIDE_MESSAGE,
            matchResult.getMatchCount(),
            matchResult.getRewardPrice(),
            winningCount
        );
    }
}
