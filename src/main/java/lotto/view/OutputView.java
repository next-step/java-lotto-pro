package lotto.view;

import lotto.constant.ViewMessageConst;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.enums.LottoRankType;

public class OutputView {
    public static void printPurchasedLottos(Lottos lottos) {
        System.out.println(String.format(ViewMessageConst.OUTPUT_MESSAGE_PURCHASED_SIZE, lottos.size()));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printLottoResult(LottoResult result) {
        System.out.println(ViewMessageConst.OUTPUT_MESSAGE_WINNING_STATISTIC);
        System.out.println(ViewMessageConst.OUTPUT_MESSAGE_DIVIDE_LINE);
        printWinningCount(result);
        printProfitRate(result);
    }

    private static void printWinningCount(LottoResult result) {
        for(LottoRankType type : LottoRankType.rankListWithReverseOrder()){
            System.out.println(String.format(ViewMessageConst.OUTPUT_MESSAGE_WINNING_COUNT_RESULT,
                    type.getMatchedCount(), type.getPrice(),
                    result.winningCountByWinningType(type)));
        }
    }

    private static void printProfitRate(LottoResult result) {
        System.out.println(String.format(ViewMessageConst.OUTPUT_MESSAGE_PROFIT_RESULT, result.getProfitRate()));
    }
}
