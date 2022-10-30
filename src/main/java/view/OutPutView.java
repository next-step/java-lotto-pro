package view;

import model.LottoNumber;
import model.LottoRankType;

import java.util.List;
import java.util.Map;

import static common.Constants.STANDARD_RESULT_PERCENT;

public class OutPutView {

    public static void outPutLottoNumber(List<LottoNumber> buyLotto) {
        for (LottoNumber lotto : buyLotto) {
            System.out.println(lotto);
        }
    }

    public static void outPutResult(Map<LottoRankType, Integer> countRank, double percent) {
        for (Map.Entry<LottoRankType, Integer> entry : countRank.entrySet()) {
            System.out.println(entry.getKey().getCount() + "개 일치 (" + entry.getKey().getWinMoney() + ")- " + entry.getValue() + "개");
        }

        System.out.println("총 수익률은 " + percent + "입니다.(기준이 1이기 때문에 결과적으로 " + convertResultWord(percent) + "라는 의미임)");
    }

    private static String convertResultWord(double percent) {
        if (percent <= STANDARD_RESULT_PERCENT) {
            return "손해";
        }

        return "이득이";
    }
}
