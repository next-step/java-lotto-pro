package lotto;

public class LottoMachine {
    private final LottoPurchaseQuantity lottoPurchaseQuantity;
    private final LottoTicket lottoTicket;

    public LottoMachine(String money) {
        lottoPurchaseQuantity = new LottoPurchaseQuantity(money);
        lottoTicket = new LottoTicket(lottoPurchaseQuantity);
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }
}
