package lotto.model;

public class LottoMachine {
    private final LottoPurchaseQuantity lottoPurchaseQuantity;
    private final LottoNumbers lottoNumbers;

    public LottoMachine(String money) {
        lottoPurchaseQuantity = new LottoPurchaseQuantity(money);
        lottoNumbers = new LottoNumbers(lottoPurchaseQuantity);
    }

    public LottoPurchaseQuantity getLottoPurchaseQuantity() {
        return lottoPurchaseQuantity;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
