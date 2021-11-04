package step3.domain;

public class LottoProvider {
    private static final int PRICE = 1000;

    private LottoProvider() {
    }

    public static LottoTicketVoucher buyLotto(int purchaseCost) {
        LottoTicketBundle lottoTicketBundle = new LottoTicketBundle();
        for (int i = 0; i < availableQuantity(purchaseCost); i++) {
            lottoTicketBundle.addLottoTicket();
        }
        return lottoTicketBundle.toLottoTicketVoucher();
    }

    private static int availableQuantity(int purchaseCost) {
        return purchaseCost / PRICE;
    }
}
