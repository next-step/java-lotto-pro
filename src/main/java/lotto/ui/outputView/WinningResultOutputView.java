package lotto.ui.outputView;

import lotto.domain.Statistics;

import static lotto.domain.WinningMoney.find;

public class WinningResultOutputView {

    public static void winningResult(Statistics statistics) {
        winningMoney(statistics);
        returnRate(statistics);
    }

    private static void returnRate(Statistics statistics) {
        System.out.println("총 수익률은 " + statistics.returnRate() + "입니다");
    }

    public static void winningMoney(Statistics statistics) {
        System.out.println("당첨통계");
        System.out.println("--------------");
        for (Integer matchCount : statistics.lottosMap().keySet()) {
            System.out.print(matchCount + "개 일치 ");
            System.out.print("(" + find(matchCount).getMoney() + "원)-");
            System.out.println(statistics.lottosMap().get(matchCount).getLottos().size() + "개");
        }
    }
}
