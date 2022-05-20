package step3.view;

import step3.domain.LottoResult;
import step3.domain.Lottos;
import step3.domain.ManualLottoCount;
import step3.domain.Ranking;

public class OutputView {
    public static void printBuyCount(ManualLottoCount manualLottoCount, int autoLottoCount) {
        System.out.printf("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", manualLottoCount.get(), autoLottoCount);
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(lotto -> System.out.println(lotto.sortedLottoNumbers()));
        System.out.println();
    }

    public static void printResult(LottoResult lottoResult, double yield) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        for (Ranking ranking : Ranking.winners()) {
            System.out.printf("%d개 일치%s(%d원)- %d개%n"
                    , ranking.getHitCount()
                    , printBonusHitMessage(ranking)
                    , (int) ranking.getWinningMoney()
                    , lottoResult.rankingCount(ranking));
        }
        System.out.printf("총 수익률은 %.02f입니다.%n", yield);
    }

    private static String printBonusHitMessage(Ranking ranking) {
        if (ranking == Ranking.SECOND) {
            return ", 보너스 볼 일치";
        }
        return " ";
    }
}
