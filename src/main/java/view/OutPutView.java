package view;

import model.LottoNumber;
import model.LottoRankType;

import java.util.List;
import java.util.Map;

public class OutPutView {

    private static final double STANDARD_RESULT_PERCENT = 0.0;

    public static void outPutLottoNumber(List<LottoNumber> buyLotto) {
        for (LottoNumber lotto : buyLotto) {
            System.out.println(lotto);
        }
    }

    public static void outPutResult(Map<LottoRankType, Integer> countRank, double percent) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        countRank
                .forEach((rankType, count) ->
                        System.out.println(rankType.getCount() + "개 일치"+ convertBonusBall(rankType) + "(" + rankType.getWinMoney() + "원) - " + count+ "개")
                );

        System.out.println("총 수익률은 " + percent + "입니다.(기준이 1이기 때문에 결과적으로 " + convertResultWord(percent) + "라는 의미임)");
    }

    private static String convertBonusBall(LottoRankType rankType) {
        if (rankType.isBonusBall()) {
            return ", 보너스볼 일치";
        }

        return "";
    }

    private static String convertResultWord(double percent) {
        if (percent <= STANDARD_RESULT_PERCENT) {
            return "손해";
        }

        return "이득이";
    }
}
