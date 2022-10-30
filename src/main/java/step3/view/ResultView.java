package step3.view;

import step3.domain.lotto.Lotto;
import step3.domain.lotto.LottoNumber;
import step3.domain.lotto.LottoNumbers;
import step3.domain.lotto.Lottos;
import step3.domain.statistics.WinningLottoType;

import java.util.List;
import java.util.Map;

import static step3.domain.statistics.WinningLottoType.*;

public class ResultView {

    public static void printLottoSize(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
    }

    public static void printLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            StringBuilder sb = getStringBuilder(lotto.getLottoNumbers());
            System.out.println(sb.toString().replaceAll(", ]", "]"));
        }
    }

    public static void printResult(Map<WinningLottoType, Integer> lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("------------");
        printWinningResult(FOURTH, lottoResult);
        printWinningResult(THIRD, lottoResult);
        printWinningResult(SECOND, lottoResult);
        printWinningResult(FIRST, lottoResult);
    }

    public static void printTotalProfit(double totalProfit) {
        System.out.printf("총 수익률은 %.2f입니다.%n", totalProfit);
    }

    private static StringBuilder getStringBuilder(LottoNumbers lottoNumbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (LottoNumber lottoNumber : lottoNumbers.value()) {
            sb.append(lottoNumber.getLottoNumber()).append(", ");
        }
        sb.append("]");
        return sb;
    }

    private static void printWinningResult(WinningLottoType winningLottoType,
                                           Map<WinningLottoType, Integer> lottoResult) {
        System.out.printf("%d개 일치 (%d원)- %d개%n",
                winningLottoType.getMatchCount(),
                winningLottoType.getWinningAmount(),
                lottoResult.getOrDefault(winningLottoType, 0)
        );
    }
}
