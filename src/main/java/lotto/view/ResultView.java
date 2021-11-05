package lotto.view;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public final class ResultView {

    private static final String SEPARATOR = ", ";
    private static final String RIGHT_SQUARE_BRACKET = "[";
    private static final String LEFT_SQUARE_BRACKET = "]";

    public static void printLottoCount(final Lottos lottos, final int manualLottoCount) {
        System.out.printf("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", manualLottoCount, lottos.count() - manualLottoCount);
    }

    public static void printLottos(final Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.print(RIGHT_SQUARE_BRACKET);
            printLotto(lotto);
            System.out.println(LEFT_SQUARE_BRACKET);
        }
        enter();
    }

    public static void printLotto(final Lotto lotto) {
        List<LottoNumber> lottoNumbers = new ArrayList<>(lotto.getLottoNumbers());

        int lottoNumberCount = lottoNumbers.size() - 1;

        for (int i = 0; i < lottoNumberCount; i++) {
            System.out.print(lottoNumbers.get(i).getValue() + SEPARATOR);
        }

        System.out.print(lottoNumbers.get(lottoNumberCount).getValue());
    }

    public static void printStatistics(final WinningsStatistics winningsStatistics) {
        enter();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Rank rank : Rank.values()) {
            printRankInfo(winningsStatistics, rank);
        }
    }

    private static void printRankInfo(final WinningsStatistics winningsStatistics, final Rank rank) {
        if (rank == Rank.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개%n", rank.getCountOfMatch(), rank.getWinningMoney(), winningsStatistics.getRankHitsCount(rank));
        }
        if (rank != Rank.MISS && rank != Rank.SECOND) {
            System.out.printf("%d개 일치 (%d원) - %d개%n", rank.getCountOfMatch(), rank.getWinningMoney(), winningsStatistics.getRankHitsCount(rank));
        }
    }

    public static void printEarningsRate(final WinningsStatistics winningsStatistics) {
        double earningsRate = winningsStatistics.calculatePrizeMoney();
        System.out.printf("총 수익률은 %s입니다.", String.format("%.2f", earningsRate));

        if (earningsRate < 1) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    private static void enter() {
        System.out.println();
    }

}
