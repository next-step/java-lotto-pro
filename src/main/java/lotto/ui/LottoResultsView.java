package lotto;

public class LottoResultsView {
    public static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f 입니다.";
    public static final double PROFIT_RATE_DECIMAL_POINT = 100.0;
    private final BuyAmount buyAmount;
    private final LottoResults lottoResults;

    public LottoResultsView(BuyAmount buyAmount, LottoResults lottoResults) {
        this.buyAmount = buyAmount;
        this.lottoResults = lottoResults;
    }

    public void showResults() {
        System.out.println(lottoResults);
    }

    public void showTotalReward() {
        System.out.println(lottoResults.getTotalReward());
    }

    public void showProfitRate() {
        System.out.printf(PROFIT_RATE_MESSAGE, buyAmount.getProfitRate(lottoResults.getTotalReward()));
    }
}
