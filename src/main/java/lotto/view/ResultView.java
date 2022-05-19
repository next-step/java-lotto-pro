package lotto.view;

import java.util.Arrays;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoRank;
import lotto.model.Lotto;
import lotto.model.LottoGameResult;
import lotto.model.Lottos;

public class ResultView {

    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String TOTAL_RESULT_HEADER_MESSAGE = "당첨 통계";
    private static final String TOTAL_RESULT_UNDER_LINE = "---------";
    private static final String RESULT_MATCH_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String RESULT_MATCH_BONUS_MESSAGE = "%d개 일치, 보너스볼 일치 (%d원)- %d개";
    private static final String RESULT_PROFIT_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final String LOSS_PROFIT_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String ENTER = "\n";
    private static final double BREAK_EVEN_POINT = 1;

    private ResultView() {
        throw new IllegalStateException(ErrorMessage.CONSTANT_CLASS);
    }

    private static String resultPurchaseView(Lottos lottos) {
        return String.format(PURCHASE_MESSAGE, lottos.lottoCount());
    }

    public static void printLottosView(Lottos lottos) {
        StringBuilder totalLottoNumberView = new StringBuilder();
        totalLottoNumberView.append(ENTER);
        totalLottoNumberView.append(resultPurchaseView(lottos));
        totalLottoNumberView.append(ENTER);
        for (Lotto lotto : lottos.getLottos()) {
            totalLottoNumberView.append(Arrays.toString(lotto.convertNumbers()));
            totalLottoNumberView.append(ENTER);
        }
        printConsole(totalLottoNumberView.toString());
    }

    public static void printFinalResultView(LottoGameResult lottoGameResult, Lottos lottos) {
        StringBuilder resultView = new StringBuilder();
        setHeader(resultView);
        for (LottoRank lottoRank : LottoRank.valuesExcludeNone()) {
            String matchMessage = formatMatchMassage(lottoGameResult, lottoRank);
            resultView.append(matchMessage);
            resultView.append(ENTER);
        }
        setProfitRateView(resultView, lottos.calcProfitRate(lottoGameResult.totalWinningAmount()));
        printConsole(resultView.toString());
    }

    private static String formatMatchMassage(LottoGameResult lottoGameResult, LottoRank lottoRank) {
        if (LottoRank.SECOND_BONUS.equals(lottoRank)) {
            return String
                    .format(RESULT_MATCH_BONUS_MESSAGE, lottoRank.getMatchNumberCount(), lottoRank.getWinningAmount(),
                            lottoGameResult.rankCount(lottoRank));
        }
        return String
                .format(RESULT_MATCH_MESSAGE, lottoRank.getMatchNumberCount(), lottoRank.getWinningAmount(),
                        lottoGameResult.rankCount(lottoRank));
    }

    private static void setHeader(StringBuilder resultView) {
        resultView.append(ENTER);
        resultView.append(TOTAL_RESULT_HEADER_MESSAGE);
        resultView.append(ENTER);
        resultView.append(TOTAL_RESULT_UNDER_LINE);
        resultView.append(ENTER);
    }

    public static void printConsole(String view) {
        System.out.println(view);
    }

    public static void setProfitRateView(StringBuilder resultView, double calcProfitRate) {
        resultView.append(String.format(RESULT_PROFIT_MESSAGE, calcProfitRate));
        if (calcProfitRate < BREAK_EVEN_POINT) {
            resultView.append(LOSS_PROFIT_MESSAGE);
        }
    }
}
