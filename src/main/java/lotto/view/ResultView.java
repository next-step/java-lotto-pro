package lotto.view;

import java.math.BigDecimal;
import lotto.model.Lotto;
import lotto.model.LottoRanking;
import lotto.model.LottoStatistics;
import lotto.model.Lottos;
import lotto.model.Money;

public class ResultView {
    private static final String WINNING_STATISTICS_YIELD = "총 수익률은 %s입니다.";
    private static final String LOTTO_PURCHASE_SIZE_RESULT = "%s개를 구매했습니다.";
    private static final String WINNING_STATISTICS_SUBJECT = "당첨 통계";
    private static final String WINNING_STATISTICS_LINE = "---------";
    private static final String WINNING_STATISTICS_DETAIL = "%s (%s원)- %s개";
    private static final String WINNING_STATISTICS_LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printPurchasedLottos(Lottos lottos) {
        printLottosSize(lottos.size());
        for (Lotto lotto : lottos.readOnlyLottos()) {
            System.out.println(lotto);
        }
        printNewLine();
    }

    private static void printLottosSize(int size) {
        System.out.printf((LOTTO_PURCHASE_SIZE_RESULT) + "%n", size);
    }

    private static void printNewLine() {
        System.out.println();
    }

    public static void printWinningStatistics(LottoStatistics lottoStatistics, Money money) {
        printNewLine();
        printWinningStatisticsSubject();
        for (LottoRanking lottoRanking : LottoRanking.values()) {
            int count = lottoStatistics.winningLottoCount(lottoRanking);
            printWinningStatisticsDetail(lottoRanking, count);
        }
        printWinningStatisticsYield(lottoStatistics, money);
    }

    private static void printWinningStatisticsSubject() {
        System.out.println(WINNING_STATISTICS_SUBJECT);
        System.out.println(WINNING_STATISTICS_LINE);
    }

    private static void printWinningStatisticsYield(LottoStatistics lottoStatistics, Money money) {
        BigDecimal yield = lottoStatistics.yield(money);
        System.out.printf(WINNING_STATISTICS_YIELD, yield);
        if (isLoss(yield)) {
            System.out.println(WINNING_STATISTICS_LOSS);
        }
    }

    private static boolean isLoss(BigDecimal yield) {
        return yield.compareTo(BigDecimal.ONE) < 0;
    }

    private static void printWinningStatisticsDetail(LottoRanking lottoRanking, int count) {
        if (isNotMiss(lottoRanking)) {
            System.out.printf((WINNING_STATISTICS_DETAIL) + "%n", lottoRanking.text(), lottoRanking.money(), count);
        }
    }

    private static boolean isNotMiss(LottoRanking lottoRanking) {
        return !LottoRanking.MISS.equals(lottoRanking);
    }
}
