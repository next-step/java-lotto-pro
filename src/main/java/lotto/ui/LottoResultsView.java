package lotto.ui;

import lotto.BuyAmount;
import lotto.LottoResults;

public class LottoResultsView {
    private final BuyAmount buyAmount;
    private final LottoResults lottoResults;

    public LottoResultsView(BuyAmount buyAmount, LottoResults lottoResults) {
        this.buyAmount = buyAmount;
        this.lottoResults = lottoResults;
    }

    public void showResults() {
        LottoMessage.showResultsTitle();
        LottoMessage.showResultsStats(lottoResults);
        LottoMessage.showProfitRate(buyAmount, lottoResults);
    }
}
