package lottoauto.view;

import lottoauto.util.YieldCalculator;
import lottoauto.wrapper.LottoCount;
import lottoauto.wrapper.Price;

import java.util.Map;

import static lottoauto.wrapper.LottoString.*;

public class OutputViewer {


    public OutputViewer(Map<Integer, Integer> winNumbers, Price price) {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("--------");
        System.out.println(FIRST_STR.getPrintValue() + " " + winNumbers.get(LottoCount.FIRST.getValue()));
        System.out.println(SECOND_STR.getPrintValue() + " " + winNumbers.get(LottoCount.SECOND.getValue()));
        System.out.println(THIRD_STR.getPrintValue() + " " + winNumbers.get(LottoCount.THIRD.getValue()));
        System.out.println(FOURTH_STR.getPrintValue() + " " + winNumbers.get(LottoCount.FOURTH.getValue()));
        System.out.println("총 수익률은 " + YieldCalculator.getYield(price.getPrice(),
                winNumbers.get(LottoCount.FIRST.getValue()), winNumbers.get(LottoCount.SECOND.getValue()),
                winNumbers.get(LottoCount.THIRD.getValue()), winNumbers.get(LottoCount.FOURTH.getValue())) + "% 입니다.");
    }

    public static void printTryTimes(int tryTimes) {
        System.out.println(tryTimes + "개를 구매했습니다.");
    }
}
