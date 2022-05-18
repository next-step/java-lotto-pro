package lotto.view;

import lotto.config.LottoGameConfig;
import lotto.domain.*;

public class ResultView {
    private static final String RESULT_PURCHASE = "%d개를 구매했습니다.";
    private static final String WINNER_RESULT_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String LOTTOS_RETURN_MONEY_RESULT = "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    private static final String LOSE = "손해";
    private static final String WIN = "이득";
    private static final String RESULT_PREFIX = "당첨 통계" + System.lineSeparator() + "---------";

    private ResultView() {
    }

    public static void printResultPurchase(int count) {
        System.out.printf(RESULT_PURCHASE + System.lineSeparator(), count);
    }

    public static void printLottoResults(LottosWinnerCounts lottosWinnerCounts, LottosResult lottosResult) {
        ResultView.printResultPrefix();
        ResultView.printLottoWinnerResult(LottoWinner.FORTH, lottosWinnerCounts);
        ResultView.printLottoWinnerResult(LottoWinner.THIRD, lottosWinnerCounts);
        ResultView.printLottoWinnerResult(LottoWinner.SECOND, lottosWinnerCounts);
        ResultView.printLottoWinnerResult(LottoWinner.FIRST, lottosWinnerCounts);
        ResultView.printLottosResult(lottosResult);
    }

    private static void printLottosResult(LottosResult lottosResult) {
        System.out.printf(LOTTOS_RETURN_MONEY_RESULT,
                lottosResult.ratio(), lottosResult.ratio() > 1 ? WIN : LOSE);
    }

    private static void printLottoWinnerResult(LottoWinner winner, LottosWinnerCounts result) {
        int winnerCount = result.winnerCount(winner);
        System.out.printf(WINNER_RESULT_FORMAT,
                winner.getRightCount(), winner.getWinnerMoney(), winnerCount);
        System.out.println();
    }

    public static void printLottos(Lottos lottos) {
        for (int i = 0; i < lottos.gameCount(); i++) {
            Lotto lotto = lottos.getLotto(i);
            printLotto(lotto);
        }
        System.out.println();
    }

    private static void printLotto(Lotto lotto) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < LottoGameConfig.LOTTO_GAME_NUMBER_COUNT; i++) {
            sb.append(lotto.lottoNumber(i))
                    .append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb);
    }

    public static void printResultPrefix() {
        System.out.println();
        System.out.println(RESULT_PREFIX);
    }
}
