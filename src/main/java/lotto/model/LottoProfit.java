package lotto.model;

public class LottoProfit {
    private final LottoPurchaseQuantity lottoPurchaseQuantity;
    private final LottoRanks lottoRanks;

    private LottoProfit(LottoPurchaseQuantity lottoPurchaseQuantity, LottoRanks lottoRanks) {
        this.lottoPurchaseQuantity = lottoPurchaseQuantity;
        this.lottoRanks = lottoRanks;
    }

    public static LottoProfit calculate(LottoPurchaseQuantity lottoPurchaseQuantity, LottoRanks lottoRanks) {
        return new LottoProfit(lottoPurchaseQuantity, lottoRanks);
    }

    public double getProfitRate() {
        return (double) lottoRanks.totalCashPrize() / lottoPurchaseQuantity.getPurchasePrice();
    }
}
