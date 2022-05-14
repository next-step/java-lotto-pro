package lotto;

import static lotto.LottoWinResult.WIN_RESULTS;

public class ResultView {

    public void purchase(final Round round) {
        System.out.println(round.purchaseSize() + "개를 구매했습니다.");
        printLottos(round);

    }

    private void printLottos(final Round round) {
        round.lottos().each(this::printLotto);
        System.out.println();
    }

    private void printLotto(final Lotto lotto) {
        System.out.println("[ " + lotto.toStringPickNumbers() + " ]");
    }

    public void drawingOfLots(final Round round) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        WIN_RESULTS.forEach(
                lottoWinResult -> printLottoWinStatistics(lottoWinResult, round.countByWinResult(lottoWinResult)));
        System.out.println("총 수익률은 " + round.totalReturnRate().toStringValue() + "입니다.");
    }

    private void printLottoWinStatistics(final LottoWinResult winResult, final long count) {
        System.out.println(winResult.getWinningCount() + "개 일치 (" + winResult.getWinningMoney().toStringValue() + "원)- "
                + count + "개");
    }
}
