package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoException;
import lotto.domain.LottoNumberMatchCount;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResultStatistics;
import lotto.domain.LottoResultStatsCalculator;
import lotto.domain.Money;

public final class ResultView {

    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final String DIVIDER_LINE_STYLE = "----------";
    private static final String LOTTO_RESULT_STATS_TITLE = "당첨 통계";
    private static final String LOTTO_RESULT_STATS_BODY_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String LOTTO_RESULT_STATS_BONUS_BODY_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원)- %d개";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.2f입니다.";
    private static final String PURCHASED_COUNT_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String PURCHASED_LOTTO_NUMBERS_FORMAT = "[%s]";

    private ResultView() {
    }

    public static void printException(final LottoException exception) {
        print(exception.getMessage());
    }

    public static void printPurchasedLottoNumbers(final List<LottoNumbers> lottoNumbers) {
        lottoNumbers.forEach(ResultView::printPurchaseLottoNumbers);
        printEmptyLine();
    }

    public static void printResult(final LottoResultStatsCalculator resultCalculator) {
        printLottoResultStatsTitle();
        printDivider();
        printLottoResultStatsBody(resultCalculator.computeLottoResultStats());
        printProfitRate(resultCalculator.computeProfitRate());
    }

    private static void print(final String message) {
        System.out.println(message);
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    private static void printPurchaseLottoNumbers(final LottoNumbers lottoNumbers) {
        print(String.format(PURCHASED_LOTTO_NUMBERS_FORMAT,
            getPurchaseLottoNumbersMessage(lottoNumbers)));
    }

    private static String getPurchaseLottoNumbersMessage(final LottoNumbers purchasedLottoNumbers) {
        return purchasedLottoNumbers.getValue().stream()
            .map(String::valueOf)
            .collect(Collectors.joining(COMMA + SPACE));
    }

    public static void printPurchasedCount(final int manualLottoCount, final int autoLottoCount) {
        print(String.format(PURCHASED_COUNT_FORMAT, manualLottoCount, autoLottoCount));
    }

    public static void printProfitRate(final Double profitRate) {
        print(String.format(PROFIT_RATE_FORMAT, profitRate));
    }

    public static void printLottoResultStatsTitle() {
        print(LOTTO_RESULT_STATS_TITLE);
    }

    public static void printDivider() {
        print(DIVIDER_LINE_STYLE);
    }

    public static void printLottoResultStatsBody(final LottoResultStatistics resultStats) {
        print(getFifthRankResultStatsMessage(resultStats));
        print(getFourthRankResultStatsMessage(resultStats));
        print(getThirdRankResultStatsMessage(resultStats));
        print(getSecondRankResultStatsMessage(resultStats));
        print(getFirstRankResultStatsMessage(resultStats));
    }

    private static String getFirstRankResultStatsMessage(final LottoResultStatistics resultStats) {
        return getRankResultStatsMessage(
            resultStats.getFirstRankLottoNumberMatchCount(),
            resultStats.getFirstRankPrizeMoney(),
            resultStats.getFirstRankCount());
    }

    private static String getSecondRankResultStatsMessage(final LottoResultStatistics resultStats) {
        return getBonusRankResultStatsMessage(
            resultStats.getSecondRankLottoNumberMatchCount(),
            resultStats.getSecondRankPrizeMoney(),
            resultStats.getSecondRankCount());
    }

    private static String getThirdRankResultStatsMessage(final LottoResultStatistics resultStats) {
        return getRankResultStatsMessage(
            resultStats.getThirdRankLottoNumberMatchCount(),
            resultStats.getThirdRankPrizeMoney(),
            resultStats.getThirdRankCount());
    }

    private static String getFourthRankResultStatsMessage(final LottoResultStatistics resultStats) {
        return getRankResultStatsMessage(
            resultStats.getFourthRankLottoNumberMatchCount(),
            resultStats.getFourthRankPrizeMoney(),
            resultStats.getFourthRankCount());
    }

    private static String getFifthRankResultStatsMessage(final LottoResultStatistics resultStats) {
        return getRankResultStatsMessage(
            resultStats.getFifthRankLottoNumberMatchCount(),
            resultStats.getFifthRankPrizeMoney(),
            resultStats.getFifthRankCount());
    }

    private static String getRankResultStatsMessage(
        final LottoNumberMatchCount lottoNumberMatchCount,
        final Money prizeMoney,
        final int rankCount
    ) {
        return String.format(LOTTO_RESULT_STATS_BODY_FORMAT,
            lottoNumberMatchCount.intValue(),
            prizeMoney.intValue(),
            rankCount);
    }

    private static String getBonusRankResultStatsMessage(
        final LottoNumberMatchCount lottoNumberMatchCount,
        final Money prizeMoney,
        final int rankCount
    ) {
        return String.format(LOTTO_RESULT_STATS_BONUS_BODY_FORMAT,
            lottoNumberMatchCount.intValue(),
            prizeMoney.intValue(),
            rankCount);
    }

}
