package study.step3.views;

import study.step3.models.Lottos;
import study.step3.models.Money;
import study.step3.Rank;
import study.step3.models.Winners;

public class ResultView {
    public static void printLottos(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        lottos.printAll();
    }

    public static void printLottoWinners(Winners winners) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printMatchingResult(winners, Rank.FOURTH);
        printMatchingResult(winners, Rank.THIRD);
        printMatchingResult(winners, Rank.SECOND);
        printMatchingResult(winners, Rank.FIRST);
    }

    private static void printMatchingResult(Winners winners, Rank rank) {
        System.out.printf("%d개 일치 (%d원)- %d개\n"
                , rank.getNumberOfMatching()
                , rank.getReward()
                , winners.numberOfRankers(rank));
    }

    public static void printEarningRate(Winners winners, Money money) {
        System.out.println(
                String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
                        , winners.earningRate(money)));
    }
}
