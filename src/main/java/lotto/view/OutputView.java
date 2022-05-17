package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constants.MessageConstants;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {

    public static void printPurchaseCount(int count) {
        System.out.printf(MessageConstants.OUTPUT_PURCHASE_COUNT, count);
    }

    public static void printLottoStats(Map<Rank, Integer> rankMap) {
        System.out.println(MessageConstants.OUTPUT_WINNING_STATS);
        System.out.println(MessageConstants.DASH_LIST);
        for (Map.Entry<Rank, Integer> elem : rankMap.entrySet()) {
            printLottoRank(elem.getKey(), elem.getValue());
        }
    }

    private static void printLottoRank(Rank rank, int rankCount) {
        System.out.printf(MessageConstants.OUTPUT_LOTTO_NUMBER_COUNT, rank.getCountOfMatch());
        if (Rank.SECOND == rank) {
            System.out.print(MessageConstants.OUTPUT_EQUALS_BONUS);
        }

        System.out.printf(MessageConstants.OUTPUT_LOTTO_WINNINGS, rank.getWinningsMoney());
        System.out.printf(MessageConstants.OUTPUT_LOTTO_SCORE_COUNT, rankCount);
        System.out.println();
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printProfitRate(double rate) {
        System.out.printf(MessageConstants.OUTPUT_PROFIT_RATE, rate);
    }
}
