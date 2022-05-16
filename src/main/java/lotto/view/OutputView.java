package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constants.MessageConstants;
import lotto.domain.Lotto;
import lotto.domain.LottoWinnings;

public class OutputView {
    public static void printPurchaseCount(int count) {
        System.out.printf(MessageConstants.OUTPUT_PURCHASE_COUNT, count);
    }

    public static void printLottoStats(Map<LottoWinnings, Integer> lottoScoreMap) {
        System.out.println(MessageConstants.OUTPUT_WINNING_STATS);
        System.out.println(MessageConstants.DASH_LIST);

        for (LottoWinnings lottoWinnings : LottoWinnings.scoreTypes()) {
            System.out.printf(MessageConstants.OUTPUT_LOTTO_NUMBER_COUNT, lottoWinnings.getCount());
            System.out.printf(MessageConstants.OUTPUT_LOTTO_WINNINGS, lottoWinnings.getWinnings());
            System.out.printf(MessageConstants.OUTPUT_LOTTO_SCORE_COUNT, lottoScoreMap.get(lottoWinnings));
            System.out.println();
        }
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printProfitRate(double rate) {
        System.out.printf(MessageConstants.OUTPUT_PROFIT_RATE, rate);
    }
}
