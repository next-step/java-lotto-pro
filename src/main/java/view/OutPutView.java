package view;

import model.LottoNumber;
import model.LottoRankType;

import java.util.List;
import java.util.Map;

import static view.OutPrintType.*;

public class OutPutView {

    private static final double STANDARD_RESULT_PERCENT = 0.0;
    public static final String OUTPUT_BARRIER = "---------";
    public static final String OPEN_BRACKET = ")";
    public static final String CLOSE_BRACKET = "(";
    public static final String EMPTY_MESSAGE = "";

    public static void outPutLottoNumber(List<LottoNumber> buyLotto) {
        for (LottoNumber lotto : buyLotto) {
            System.out.println(lotto);
        }
    }

    public static void outPutResult(Map<LottoRankType, Integer> countRank, double percent) {
        System.out.println(LOTTO_RESULT.getMessage());
        System.out.println(OUTPUT_BARRIER);

        countRank
                .forEach((rankType, count) ->
                        System.out.println(rankType.getCount() +
                                SAME_COUNT.getMessage() + convertBonusBall(rankType) +
                                CLOSE_BRACKET + rankType.getWinMoney() +
                                WON_INPUT.getMessage() + count + COUNT_INPUT.getMessage())
                );

        System.out.println(TOTAL_GET_PERCENT.getMessage() + percent + STANDARD_RESULT.getMessage() + convertResultWord(percent) + MEAN_RESULT.getMessage() + OPEN_BRACKET);
    }

    private static String convertBonusBall(LottoRankType rankType) {
        if (rankType.isBonusBall()) {
            return SAME_BONUS_BALL.getMessage();
        }

        return EMPTY_MESSAGE;
    }

    private static String convertResultWord(double percent) {
        if (percent <= STANDARD_RESULT_PERCENT) {
            return WIN_RESULT.getMessage();
        }

        return LOSE_RESULT.getMessage();
    }

    public static void oupPutBuyLottoTypeCount(int manualCount, int autoCount) {
        System.out.println(MANUAL.getMessage() + manualCount + AUTO.getMessage() + autoCount + BUY_COUNT.getMessage());
    }
}
