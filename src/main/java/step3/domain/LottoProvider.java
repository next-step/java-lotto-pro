package step3.domain;

import java.util.List;

public class LottoProvider {
    private static final int PRICE = 1000;

    private final int purchaseCost;

    public LottoProvider(int purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public List<List<Integer>> buyLotto() {
        LottoTicketBundle lottoTicketBundle = new LottoTicketBundle();
        for (int i = 0; i < availableQuantity(); i++) {
            lottoTicketBundle.addLottoTicket();
        }
        return lottoTicketBundle.getUnmodifiableListLottoTickets();
    }

    public int availableQuantity() {
        return purchaseCost / PRICE;
    }

    public int totalPurchasePrice(int quantity) {
        return quantity * PRICE;
    }
}
