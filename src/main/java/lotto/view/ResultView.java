package lotto.view;

import lotto.Lottos;
import lotto.Rank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ResultView {

    private static final String PRINT_QUANTITY_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String STATISTICS_HEADER_MESSAGE = "당첨 통계";
    private static final String LINE = "---------";
    private static final String STATISTICS_MESSAGE = "%d개 일치 (%d원) - %d개";
    private static final String STATISTICS_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final int LOSS_MINIMUM_SCORE = 1;

    public static void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
        System.out.println();
    }

    public static void printQuantity(int passiveQuantity, int autoQuantity) {
        System.out.printf((PRINT_QUANTITY_MESSAGE) + "%n", passiveQuantity, autoQuantity);
    }

    ;

    public static void printStatistics(List<Rank> ranks) {
        System.out.println(STATISTICS_HEADER_MESSAGE);
        System.out.println(LINE);

        Arrays.stream(Rank.values()).filter(rank -> rank != Rank.LOSE)
                .forEach(
                        rank -> System.out.printf(
                                rank == Rank.SECOND ? STATISTICS_BONUS_MESSAGE + "%n" : STATISTICS_MESSAGE + "%n",
                                rank.getCount(),
                                rank.getWinningMoney(),
                                Collections.frequency(ranks, rank)
                        )
                );
    }

    public static void printProfitRate(double profitRate) {
        StringBuilder message = new StringBuilder();
        message.append(String.format(PROFIT_RATE_MESSAGE, profitRate));
        if (profitRate < LOSS_MINIMUM_SCORE) {
            message.append(LOSS_MESSAGE);
        }
        System.out.println(message);
    }

}
