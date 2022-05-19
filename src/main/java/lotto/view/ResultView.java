package lotto.view;

import lotto.model.Earning;
import lotto.model.LottoNumbers;
import lotto.model.RankCount;

public class ResultView {
    private static final String PURCHASE_COUNT_OUTPUT_MESSAGE = "%d개를 구매했습니다.";
    private static final String EARNINGS_RATE_OUTPUT_MESSAGE = "총 수익률은 %s입니다.";

    public static void printPurchaseCountView(int count) {
        System.out.printf(PURCHASE_COUNT_OUTPUT_MESSAGE + "\n", count);
    }

    public static void printLottoNumbers(LottoNumbers lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printStatisticsHeader() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
    }

    public static void printRankCount(RankCount rankCount) {
        System.out.println(rankCount);
    }

    public static void printEarning(Earning earning) {
        System.out.printf(EARNINGS_RATE_OUTPUT_MESSAGE, earning);
        System.out.println();
    }
}
