package lotto.view;

import java.util.Arrays;
import lotto.constant.LottoMatchNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class ResultView {

    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String TOTAL_RESULT_HEADER_MESSAGE = "당첨 통계";
    private static final String TOTAL_RESULT_UNDER_LINE = "---------";
    private static final String RESULT_MATCH_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String RESULT_PROFIT_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final String ENTER = "\n";

    private String resultPurchaseView(Lottos lottos) {
        return String.format(PURCHASE_MESSAGE, lottos.lottoCount());
    }

    public void generatedLottosView(Lottos lottos) {
        StringBuilder totalLottoNumberView = new StringBuilder();
        totalLottoNumberView.append(resultPurchaseView(lottos));
        totalLottoNumberView.append(ENTER);
        for (Lotto lotto : lottos.getLottoList()) {
            totalLottoNumberView.append(Arrays.toString(lotto.numberListToArray()));
            totalLottoNumberView.append(ENTER);
        }
        printView(totalLottoNumberView.toString());
    }

    public void totalResultView(Lottos lottos) {
        StringBuilder resultView = new StringBuilder();
        setHeader(resultView);
        for (LottoMatchNumber lottoMatchNumber : LottoMatchNumber.allMatchNumber()) {
            resultView.append(ENTER);
            int resultCount = lottos.getResultCount(lottoMatchNumber.getMatchNumberCount());
            String resultMatchMessage = String.format(RESULT_MATCH_MESSAGE, lottoMatchNumber.getMatchNumberCount(),
                    lottoMatchNumber.getWinningAmount(), resultCount);
            resultView.append(resultMatchMessage);
        }
        setProfitRate(lottos, resultView);
        printView(resultView.toString());
    }

    private void setHeader(StringBuilder resultView) {
        resultView.append(ENTER);
        resultView.append(TOTAL_RESULT_HEADER_MESSAGE);
        resultView.append(ENTER);
        resultView.append(TOTAL_RESULT_UNDER_LINE);
    }

    private void setProfitRate(Lottos lottos, StringBuilder resultView) {
        resultView.append(ENTER);
        String profitRate = String.format(RESULT_PROFIT_MESSAGE, lottos.getResultProfitRate());
        resultView.append(profitRate);
    }

    private void printView(String view) {
        System.out.println(view);
    }
}
