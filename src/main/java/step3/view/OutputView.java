package step3.view;

import step3.domain.LottoResult;
import step3.domain.Lottos;
import step3.domain.Ranking;

public class OutputView {
    public static void printBuyCount(int buyCount) {
        System.out.printf("%d개를 구매했습니다.%n", buyCount);
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(lotto -> System.out.println(lotto.sortedLottoList()));
        System.out.println();
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        for (Ranking ranking : Ranking.winners()) {
            System.out.printf("%d개 일치 (%f원)- %d개%n", ranking.getHitCount(), ranking.getWinningMoney(), lottoResult.rankingCount(ranking));
        }
        System.out.printf("총 수익률은 %.02f입니다.%n", lottoResult.getYield());
    }
}
