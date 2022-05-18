package lotto.view;

import lotto.constant.ViewMessageConst;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.enums.LottoRank;

public class OutputView {
    private static final String EMPTY_STRING = "";
    private static final String DELIMITER_COMMA = ", ";

    public static void printPurchasedLottos(Lottos lottos) {
        System.out.println(String.format(ViewMessageConst.OUTPUT_MESSAGE_PURCHASED_SIZE, lottos.size()));
        for (Lotto lotto : lottos.getLottosAsUnmodifiableList()) {
            System.out.println(lotto.lottoNumbers());
        }
    }

    public static void printLottoResult(LottoResult result, double profit) {
        System.out.println(ViewMessageConst.OUTPUT_MESSAGE_WINNING_STATISTIC);
        System.out.println(ViewMessageConst.OUTPUT_MESSAGE_DIVIDE_LINE);
        printWinningCount(result);
        printProfitRate(profit);
    }

    private static void printWinningCount(LottoResult result) {
        for(LottoRank rank : LottoRank.rankListWithReverseOrder()){
            System.out.println(String.format(ViewMessageConst.OUTPUT_MESSAGE_WINNING_COUNT_RESULT,
                    rank.getMatchedCount(), printBonusBallMatched(rank.bonusBallMatched()), rank.getPrice(),
                    result.winningCountByRank(rank)));
        }
    }

    private static String printBonusBallMatched(boolean bonusBallMatched) {
        if(bonusBallMatched){
            return DELIMITER_COMMA + ViewMessageConst.OUTPUT_MESSAGE_BONUSBALL_MATCHED;
        }
        return EMPTY_STRING;
    }

    private static void printProfitRate(double profit) {
        System.out.println(String.format(ViewMessageConst.OUTPUT_MESSAGE_PROFIT_RESULT, profit));
    }
}
