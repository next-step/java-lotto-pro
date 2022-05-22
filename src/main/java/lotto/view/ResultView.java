package lotto.view;

import lotto.model.LottoNumbers;
import lotto.model.Statistics;

public class ResultView {
    private static final String PURCHASE_COUNT_OUTPUT_MESSAGE = "%d개를 구매했습니다.";
    private static final String EARNINGS_RATE_OUTPUT_MESSAGE = "총 수익률은 %s입니다.";

    private ResultView() {}

    public static void printPurchaseCountView(int count) {
        System.out.printf(PURCHASE_COUNT_OUTPUT_MESSAGE + "\n", count);
    }

    public static void printLottoNumbers(LottoNumbers lottoNumbers) {
        System.out.println(lottoNumbers);
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
