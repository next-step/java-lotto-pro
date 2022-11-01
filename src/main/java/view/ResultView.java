package view;

import static domain.LottoWinning.NONE;

import domain.Lotto;
import domain.LottoResult;
import domain.LottoWinning;
import java.util.Arrays;
import java.util.List;

public class ResultView {
    public static void printLottoResult(LottoResult lottoResult) {
        printLottoResultPrefix();
        printWinningResult(lottoResult);
        printEarningRate(lottoResult.getEarningRate());
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다\n", lottos.size());
        lottos.forEach(System.out::println);
        System.out.print("\n");
    }

    private static void printLottoResultPrefix() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private static void printWinningResult(LottoResult lottoResult) {
        Arrays.stream(LottoWinning.values())
            .filter(lottoWinning -> !lottoWinning.equals(NONE))
            .forEach(lottoWinning -> System.out.printf("%d개 일치 (%d원)- %d개\n",
                lottoWinning.getMaxNumberMatched(),
                lottoWinning.getPrize(),
                lottoResult.findWinning(lottoWinning)));
    }

    private static void printEarningRate(float earningRate) {
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n",
            earningRate);
    }
}
