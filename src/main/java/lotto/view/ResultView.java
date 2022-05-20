package lotto.view;

import lotto.Lottos;
import lotto.Rank;

import java.util.Map;

public class ResultView {

    private static final String PRINT_QUANTITY_MESSAGE = "%d개를 구매했습니다.";
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

    public static void printQuantity(int quantity) {
        System.out.printf((PRINT_QUANTITY_MESSAGE) + "%n", quantity);
    };

    public static void printStatistics(final Map<Rank, Integer> gameResult) {
        System.out.println(STATISTICS_HEADER_MESSAGE);
        System.out.println(LINE);
        for (Rank rank : gameResult.keySet()) {
            printRank(rank, gameResult.get(rank));
        }
    }

    private static void printRank(final Rank rank, final int count) {
        if(rank.equals(Rank.LOSE)) {
            return;
        }
        if (rank.equals(Rank.SECOND)) {
            System.out.printf((STATISTICS_BONUS_MESSAGE) + "%n", rank.getCount(), rank.getWinningMoney(), count);
            return;
        }
        System.out.printf((STATISTICS_MESSAGE) + "%n", rank.getCount(), rank.getWinningMoney(), count);
    }

    public static void printProfitRate(double profitRate) {
        StringBuilder message = new StringBuilder();
        message.append(String.format(PROFIT_RATE_MESSAGE, profitRate));
        if(profitRate < LOSS_MINIMUM_SCORE) {
            message.append(LOSS_MESSAGE);
        }
        System.out.println(message);
    }

}
