package lottoauto.view;

import lottoauto.util.YieldCalculator;
import lottoauto.util.Rank;
import lottoauto.wrapper.Price;

import java.util.Map;

import static lottoauto.wrapper.LottoString.*;

public class OutputViewer {


    public OutputViewer(Map<Integer, Integer> winNumbers, Price price) {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("--------");
        System.out.println(FIRST_STR.getPrintValue() + " " + winNumbers.get(Rank.FIRST.getLottoRank()));
        System.out.println(SECOND_STR.getPrintValue() + " " + winNumbers.get(Rank.SECOND.getLottoRank()));
        System.out.println(THIRD_STR.getPrintValue() + " " + winNumbers.get(Rank.THIRD.getLottoRank()));
        System.out.println(FOURTH_STR.getPrintValue() + " " + winNumbers.get(Rank.FOURTH.getLottoRank()));
        System.out.println(FIFTH_STR.getPrintValue() + " " + winNumbers.get(Rank.FIFTH.getLottoRank()));
        System.out.println("총 수익률은 " + YieldCalculator.getYield(price.getPrice(),
                winNumbers.get(Rank.FIRST.getLottoRank()), winNumbers.get(Rank.SECOND.getLottoRank()),
                winNumbers.get(Rank.THIRD.getLottoRank()), winNumbers.get(Rank.FOURTH.getLottoRank()),
                winNumbers.get(Rank.FIRST.getLottoRank())) + "% 입니다.");
    }

    public static void printTryTimes(int tryTimes) {
        System.out.println(tryTimes + "개를 구매했습니다.");
    }
}
