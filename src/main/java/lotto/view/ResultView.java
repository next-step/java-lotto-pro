package lotto.view;

import lotto.model.Lottos;
import lotto.model.Purchase;
import lotto.model.Statistics;

public class ResultView {
    private static final String PURCHASE_COUNT_OUTPUT_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String EARNINGS_RATE_OUTPUT_MESSAGE = "총 수익률은 %s입니다.";

    private ResultView() {}

    public static void printPurchaseCountView(Purchase purchase) {
        System.out.printf(PURCHASE_COUNT_OUTPUT_MESSAGE + "\n", purchase.getManualCount(), purchase.getAutoCount());
    }

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void printStatistics(Statistics statistics) {
        printStatisticsHeader();
        System.out.println(statistics.getRankCount());
        System.out.printf(EARNINGS_RATE_OUTPUT_MESSAGE, statistics.getEarning());
    }

    private static void printStatisticsHeader() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
    }
}
