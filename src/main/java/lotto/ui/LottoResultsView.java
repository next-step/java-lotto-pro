package lotto.ui;

import lotto.BuyAmount;
import lotto.LottoResults;

public class LottoResultsView {
    public static final String RESULT_STATS_TITLE = "당첨 통계";
    public static final String RESULT_SEPARATE_LINE = "---------";
    public static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f 입니다.";
    private final BuyAmount buyAmount;
    private final LottoResults lottoResults;

    public LottoResultsView(BuyAmount buyAmount, LottoResults lottoResults) {
        this.buyAmount = buyAmount;
        this.lottoResults = lottoResults;
    }

    public void showResults() {
        showResultsTitle();
        showResultsStats();
        showProfitRate();
    }

    public void showResultsTitle() {
        System.out.println(RESULT_STATS_TITLE);
        System.out.println(RESULT_SEPARATE_LINE);
    }

    public void showResultsStats() {
        System.out.println(lottoResults);
    }

    public void showTotalReward() {
        System.out.println(lottoResults.getTotalReward());
    }

    public void showProfitRate() {
        System.out.printf(PROFIT_RATE_MESSAGE, buyAmount.getProfitRate(lottoResults.getTotalReward()));
    }
}
