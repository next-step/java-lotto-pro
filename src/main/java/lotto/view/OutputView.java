package lotto.view;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import lotto.constants.MessageConstants;
import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.domain.Rank;

public class OutputView {

    public static void printPurchaseCountByLottoType(int manualCount, int autoCount) {
        System.out.printf(MessageConstants.OUTPUT_PURCHASE_COUNT_BY_LOTTO_TYPE, manualCount,
            autoCount);
        System.out.println();
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
        lottos.forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers().stream().map(LottoNo::getLottoNo)
                .collect(toList());
            System.out.println(numbers);
        });
    }

    public static void printProfitRate(double rate) {
        System.out.printf(MessageConstants.OUTPUT_PROFIT_RATE, rate);
    }
}
