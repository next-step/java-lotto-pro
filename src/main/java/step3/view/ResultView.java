package step3.view;

import step3.domain.lotto.Lottos;
import step3.domain.statistics.LottoStatistics;

public class ResultView {

    public static void printLottosQuantity(Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.value().size());
    }

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void printResult(LottoStatistics lottoStatistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("------------");
        System.out.println(lottoStatistics);
    }

    public static void printTotalProfit(LottoStatistics lottoStatistics) {
        System.out.printf("총 수익률은 %.2f입니다.%n", lottoStatistics.getTotalProfit());
    }
}
