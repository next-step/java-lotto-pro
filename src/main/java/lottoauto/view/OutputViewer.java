package lottoauto.view;

import lottoauto.util.Rank;
import lottoauto.wrapper.Price;

import java.util.Map;

public class OutputViewer {


    public OutputViewer(Map<Integer, Integer> winNumbers, Price price) {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("--------");
        Rank rank[] = Rank.values();
        for (Rank r : rank) {
            System.out.println(r.getLottoString() + " " + winNumbers.get(r.getLottoRank()));
        }

        Double yield = Rank.getYield(winNumbers, price);

        System.out.println("총 수익률은 " + yield + "% 입니다.");

    }

    public static void printTryTimes(int tryTimes) {
        System.out.println(tryTimes + "개를 구매했습니다.");
    }
}
