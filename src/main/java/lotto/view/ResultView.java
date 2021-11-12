package lotto.view;

import lotto.domain.*;
import lotto.domain.common.Constant;
import lotto.enums.Ranking;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    private ResultView(){}

    private static final String RIGHT_SQUARE_BRACKET = "[";
    private static final String LEFT_SQUARE_BRACKET = "]";

    public static void printPurchaseConfirmation(final Payment payment) {
        System.out.printf("%d개를 구매했습니다.%n", payment.getPurchaseCount());
    }

    public static void printLottos(final Lottos lottos) {
        for (Lotto lotto : lottos.getLottosList()) {
            System.out.print(RIGHT_SQUARE_BRACKET);
            printLotto(lotto);
            System.out.println(LEFT_SQUARE_BRACKET);
        }
        lineBreak();
    }

    public static void printPurchaseLotto(final int autoLottoCount, final int manualLottoCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.%n", autoLottoCount, manualLottoCount);
    }

    public static void printLotto(final Lotto lotto) {
        List<LottoNumber> lottoNumbers = new ArrayList<>(lotto.getLottoNumbers());
        int lottoNumberCount = lottoNumbers.size() - 1;
        for (int i = 0; i < lottoNumberCount; i++) {
            System.out.print(lottoNumbers.get(i).getValue() + Constant.SEPERATOR);
        }
        System.out.print(lottoNumbers.get(lottoNumberCount).getValue());
    }

    public static void printStatistics(final WinningStatistics winningsStatistics) {
        lineBreak();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Ranking ranking : Ranking.values()) {
            printRankInfo(winningsStatistics, ranking);
        }
    }

    private static void printRankInfo(final WinningStatistics winningsStatistics, final Ranking ranking) {
        if (ranking != Ranking.MISS) {
            System.out.printf("%s (%d원) - %d개%n", ranking.getMessage(), ranking.getAmount(), winningsStatistics.getRankHitsCount(ranking));
        }
    }

    public static void printEarningsRate(final WinningStatistics winningsStatistics) {
        double earningsRate = winningsStatistics.calculatePrizeMoney();
        System.out.printf("총 수익률은 %s입니다.", String.format("%.2f", earningsRate));

        if (earningsRate < 1) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    private static void lineBreak() {
        System.out.println();
    }
}
