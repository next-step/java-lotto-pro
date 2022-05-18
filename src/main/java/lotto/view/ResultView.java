package lotto.view;

import lotto.Lottos;
import lotto.Rank;

import java.util.List;

public class ResultView {

    private static final String PRINT_QUANTITY_MESSAGE = "%d개를 구매했습니다.";
    private static final String STATISTICS_HEADER_MESSAGE = "당첨 통계";
    private static final String LINE = "---------";
    private static final String STATISTICS_MESSAGE = "%d개 일치 (%d원)- %d개";
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

    public static void printStatistics(List<Rank> ranks) {
        System.out.println(STATISTICS_HEADER_MESSAGE);
        System.out.println(LINE);
        printRank(ranks, Rank.FOURTH);
        printRank(ranks, Rank.THIRD);
        printRank(ranks, Rank.SECOND);
        printRank(ranks, Rank.FIRST);
    }

    private static void printRank(List<Rank> ranks, Rank targetRank) {
        int count = 0;
        for (Rank rank : ranks) {
            count += plusCount(targetRank, rank);
        }
        System.out.printf((STATISTICS_MESSAGE) + "%n", targetRank.getCount(), targetRank.getWinningMoney(), count);
    }

    private static int plusCount(Rank targetRank, Rank rank) {
        if (targetRank.equals(rank)) {
            return 1;
        }
        return 0;
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
