package lotto.view;

import lotto.model.Lottos;
import lotto.model.MatchPoint;
import lotto.model.WinningLotto;
import lotto.util.MessageUtil;

public class ResultView {
    private final static String PURCHASE_LOTTOS_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private final static String WINNING_STATISTICS_TITLE_MESSAGE = "당첨 통계\n---------";
    private final static String WINNING_STATISTICS_MESSAGE = "%d개 일치 (%d원)- %d개";
    private final static String TOTAL_EARNINGS_RATE_MESSAGE = "총 수익률은 %.2f입니다.";

    public final static String ERROR_DUPLICATION_NUMBER = "중복된 값이 있습니다.";

    private final MessageUtil message;

    public ResultView() {
        message = new MessageUtil();
    }

    public void printPurchaseLottos(Lottos lottos) {
        message.printMessage(String.format(PURCHASE_LOTTOS_COUNT_MESSAGE, lottos.lottosCount()));
        message.printMessage(lottos.numbersToString());
    }

    public void printWinningStatisticsTitle() {
        message.printMessage();
        message.printMessage(WINNING_STATISTICS_TITLE_MESSAGE);
    }

    public void printWinningStatistics(WinningLotto winningLotto) {
        for (MatchPoint matchPoint : MatchPoint.findValues()) {
            message.printMessage(String.format(WINNING_STATISTICS_MESSAGE, matchPoint.getMatchPointCount(), matchPoint.getCashPrize(), winningLotto.findWinningCount(matchPoint)));
        }
    }

    public void printTotalEarningsRate(WinningLotto winningLotto, long lottosTotalPrice) {
        message.printMessage(String.format(TOTAL_EARNINGS_RATE_MESSAGE, winningLotto.findEarningsRate(lottosTotalPrice)));
    }
}
