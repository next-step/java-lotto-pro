package lotto;

import static lotto.Message.LOSS_STATISTICS_MESSAGE;
import static lotto.Message.PRINT_LOTTO_NUMBERS;
import static lotto.Message.PURCHASE_LOTTO_COUNT_MESSAGE;
import static lotto.Message.RETURN_RATE_MESSAGE;
import static lotto.Message.STATISTICS_START_MESSAGE;
import static lotto.Message.TOTAL_SUMMARY_MESSAGE;
import static lotto.domain.LottoWinResult.WIN_RESULTS;

import lotto.domain.Lotto;
import lotto.domain.LottoWinResult;
import lotto.domain.LottoWinStatistics;
import lotto.domain.Lottos;

public class ResultView {

    public void purchase(final Lottos lottos) {
        System.out.printf(PURCHASE_LOTTO_COUNT_MESSAGE, lottos.size());
        printLottos(lottos);
    }

    private void printLottos(final Lottos lottos) {
        lottos.each(this::printLotto);
        System.out.println();
    }

    private void printLotto(final Lotto lotto) {
        System.out.printf(PRINT_LOTTO_NUMBERS, lotto.toStringPickNumbers());
    }

    public void drawingOfLots(final LottoWinStatistics statistics) {
        System.out.printf(STATISTICS_START_MESSAGE);
        WIN_RESULTS.forEach(
                lottoWinResult -> printLottoWinStatistics(lottoWinResult, statistics.countByWinResult(lottoWinResult)));
        System.out.printf(RETURN_RATE_MESSAGE, statistics.getReturnRate().getValue());
        if (statistics.isLoss()) {
            System.out.printf(LOSS_STATISTICS_MESSAGE);
        }
    }

    private void printLottoWinStatistics(final LottoWinResult winResult, final long count) {
        System.out.printf(TOTAL_SUMMARY_MESSAGE, winResult.getWinningCount(), winResult.getWinningMoney().toStringValue(), count);
    }
}
