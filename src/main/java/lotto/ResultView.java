package lotto;

import static lotto.domain.LottoWinResult.WIN_RESULTS;

import lotto.domain.Lotto;
import lotto.domain.LottoWinResult;
import lotto.domain.LottoWinStatistics;
import lotto.domain.Lottos;

public class ResultView {

    public void purchase(final Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        printLottos(lottos);
    }

    private void printLottos(final Lottos lottos) {
        lottos.each(this::printLotto);
        System.out.println();
    }

    private void printLotto(final Lotto lotto) {
        System.out.println("[ " + lotto.toStringPickNumbers() + " ]");
    }

    public void drawingOfLots(final LottoWinStatistics statistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        WIN_RESULTS.forEach(
                lottoWinResult -> printLottoWinStatistics(lottoWinResult, statistics.countByWinResult(lottoWinResult)));
        System.out.print("총 수익률은 " + statistics.getReturnRate().toStringValue() + "입니다.");
        if (statistics.isLoss()) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    private void printLottoWinStatistics(final LottoWinResult winResult, final long count) {
        System.out.println(winResult.getWinningCount() + "개 일치 (" + winResult.getWinningMoney().toStringValue() + "원)- "
                + count + "개");
    }
}
